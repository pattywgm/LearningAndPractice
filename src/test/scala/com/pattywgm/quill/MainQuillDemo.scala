package com.pattywgm.quill

import java.util.UUID

import com.pattywgm.quill.models.{UserStat, NewsQueryOption, News, NewsSource}
import com.pattywgm.quill.services.{UserService, NewsService}
import org.joda.time.DateTime

/**
  * Version: 1.1
  * Author: pattywgm 
  * Time: 16/9/14 下午2:54
  * Desc:
  */

case class User(userId: UUID, age: Int, name: String)

object MainQuillDemo extends App {

  val newService: NewsService = new NewsService
//  newService.insNews(News(12, "国庆大放价", "", "http://www.mooncake.com", NewsSource.SINA, DateTime.now)).map{
//    case 1L => newService.getById(12).map{
//      case Some(news) => println(news)
//      case None => throw new Exception("Inserted, but not found!")
//    }
//    case _ => throw new Exception("Inserted Error!!!")
//  }

//  newService.updNews(News(3, "国庆人流暴涨啊啊啊啊啊啊啊!", "国庆人流暴涨", "http://www.quill.com", NewsSource.SINA, DateTime.now))

  newService.select(NewsQueryOption(ids=List(1,2), title = "话题", source=Seq.empty)).map{
    items => println(items)
  }
//
//  val userService: UserService = new UserService
//  userService.update(UserStat(UUID.fromString("fc9b76d1-8d08-11e6-bc46-acbc327c3dc1"), 1L, 1L))
  Thread.sleep(3000)
}
