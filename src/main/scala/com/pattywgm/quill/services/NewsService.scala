package com.pattywgm.quill.services

import com.pattywgm.quill.models.{NewsQueryOption, NewsC, News}
import com.pattywgm.quill.modules.AppDataBase
import com.twitter.util.Future

/**
  * Version: 1.1
  * Author: pattywgm 
  * Time: 16/9/14 下午2:43
  * Desc:
  */

class NewsService {
  val appDataBase: AppDataBase = new AppDataBase

  def getById(id: Int): Future[Option[News]] = {
    appDataBase.newsCql.getById(id).flatMap {
      content =>
        appDataBase.newsSql.getById(id).map {
          case Some(news) => Some(news.copy(content = content))
          case None => throw new Exception("News doesn't exists!")
        }
    }
  }

  def insNews(news: News): Future[Long] = {
    appDataBase.newsCql.insNews(NewsC(news.id, news.content))
    appDataBase.newsSql.insNews(news.copy(content = ""))
  }

  def updNews(news: News) = {
    appDataBase.newsCql.updNews(NewsC(news.id, news.content))
    appDataBase.newsSql.updNews(news.copy(content = ""))
  }

  def updLink(id: Int, link: String): Future[Long] = {
    appDataBase.newsSql.updLink(id, link)
  }

  def delOrder(id: Int): Future[Long] = {
    appDataBase.newsCql.delNews(id)
    appDataBase.newsSql.delNews(id)
  }

  def select(option: NewsQueryOption): Future[Seq[News]] = {
    appDataBase.newsSql.select(option)
  }
}
