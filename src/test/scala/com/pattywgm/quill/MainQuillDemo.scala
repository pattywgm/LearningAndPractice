package com.pattywgm.quill

import com.pattywgm.quill.models.{News, NewsSource}
import com.pattywgm.quill.services.NewsService
import org.joda.time.DateTime

/**
  * Version: 1.1
  * Author: pattywgm 
  * Time: 16/9/14 下午2:54
  * Desc:
  */

case class User(userId: String, age: Int, name: String)

object MainQuillDemo extends App {

  val newService: NewsService = new NewsService
//  newService.insNews(News(3, "国庆大放价", "", "http://www.mooncake.com", NewsSource.SINA, DateTime.now)).map{
//    case 1L => newService.getById(3).map{
//      case Some(news) => println(news)
//      case None => throw new Exception("Inserted, but not found!")
//    }
//    case _ => throw new Exception("Inserted Error!!!")
//  }

  newService.updNews(News(3, "国庆人流暴涨啊啊啊啊啊啊啊!", "国庆人流暴涨", "http://www.quill.com", NewsSource.SINA, DateTime.now))
  Thread.sleep(3000)
}
