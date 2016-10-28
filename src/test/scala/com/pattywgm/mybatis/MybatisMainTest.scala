package com.pattywgm.mybatis

import com.pattywgm.mybatis.daos.FreshLikeDao
import com.pattywgm.mybatis.models.FreshLike
import com.pattywgm.mybatis.modules.Config
import org.joda.time.DateTime

/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/10/20 下午5:07
  * Desc:
  */
object MybatisMainTest extends App{
  val db = Config.persistenceContext

  db.transaction { implicit session =>
    val f = new FreshLike
    f.userId = "user2"
    f.freshId = "fresh2"
    f.cTime = DateTime.now()
//    FreshLikeDao.insertOne(f)
//    FreshLikeDao.deleteOne(f)
//    FreshLikeDao.updateOne(f)
//    FreshLikeDao.getById("user2") foreach(print(_))
    FreshLikeDao.getByUserId("user_") foreach(println(_))
  }
}
