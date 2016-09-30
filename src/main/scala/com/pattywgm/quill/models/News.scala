package com.pattywgm.quill.models

import java.util.Date

import com.pattywgm.quill.models.NewsSource.NewsSourceEnum
import com.twitter.util.Future
import io.getquill.{CamelCase, CassandraAsyncContext, FinagleMysqlContext}
import org.joda.time.DateTime

import com.twitter.bijection.Conversion._
import com.twitter.bijection.twitter_util.UtilBijections.twitter2ScalaFuture
import com.twitter.util.{Future => TwitterFuture}

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Version: 1.1
  * Author: pattywgm 
  * Time: 16/8/30 下午2:31
  * Desc:
  */
object NewsSource extends Enumeration {
  type NewsSourceEnum = Value
  val SINA = Value(3)
  val NETEASE = Value(5)
  val SOHU = Value(7)
  val TENCENT = Value(9)
}

case class News(id: Int, content: String, title: String, link: String, source: NewsSourceEnum, publishTime: DateTime)

case class NewsC(id: Int, content: String)

abstract class ConcreteSqlNews(val mariadb: FinagleMysqlContext[CamelCase]) {

  import mariadb._

  implicit val encodeEnum = MappedEncoding[String, NewsSourceEnum](NewsSource.withName(_))
  implicit val decodeEnum = MappedEncoding[NewsSourceEnum, String](_.toString)

  implicit val encodeDate = MappedEncoding[Date, DateTime](new DateTime(_))
  implicit val decodeDate = MappedEncoding[DateTime, Date](_.toDate)

  def getById(id: Int): TwitterFuture[Option[News]] = {
    mariadb.run(quote(query[News].filter(_.id == lift(id)))).map(_.headOption)
  }

  def insNews(news: News): TwitterFuture[Long] = {
    mariadb.run(quote(query[News].insert(lift(news))))
  }

  def updNews(news: News): TwitterFuture[Long] = {
    mariadb.run(quote(query[News].filter(_.id == lift(news.id)).update(lift(news))))
  }

  def updLink(id: Int, link: String): TwitterFuture[Long] = {
    mariadb.run(quote(query[News].filter(_.id == lift(id)).update(_.link -> lift(link))))
  }

  def delNews(id: Int): TwitterFuture[Long] = {
    mariadb.run(quote(query[News].filter(_.id == lift(id)).delete))
  }
}

abstract class ConcreteCqlNews(val ctx: CassandraAsyncContext[CamelCase]) {

  import ctx._

  val newsC = quote(query[NewsC].schema(_.entity("news")))

  def insNews(news: NewsC) = {
    ctx.run(quote(newsC.insert(lift(news))))
  }

  def delNews(id: Int) = {
    ctx.run(quote(newsC.filter(_.id == lift(id)).delete))
  }

  def updNews(news: NewsC) = {
    ctx.run(quote(newsC.filter(_.id == lift(news.id)).update(_.content -> lift(news.content))))
  }


  // 此处将scala.concurent.Future转为twitter.Future
  def getById(id: Int): TwitterFuture[String] = {
    ctx.run(quote(newsC.filter(_.id == lift(id)))).map(_.headOption).map {
      case Some(item) => item.content
      case None => throw new Exception("News doesn't exists!")
    }.as[TwitterFuture[String]]
  }
}
