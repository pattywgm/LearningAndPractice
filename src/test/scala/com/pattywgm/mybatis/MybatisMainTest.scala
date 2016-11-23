package com.pattywgm.mybatis

import com.pattywgm.mybatis.daos.FreshDao
import com.pattywgm.mybatis.models._
import com.pattywgm.mybatis.modules.Config
import org.joda.time.DateTime
import org.mybatis.scala.session.RowBounds

/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/10/20 下午5:07
  * Desc:
  */
object MybatisMainTest extends App {
  val db = Config.persistenceContext

  db.transaction { implicit session =>

    //    val f = new FreshLike("user6", "fresh6", DateTime.now())
    //    val f2 = FreshLike.apply("user6", "fresh6", DateTime.now())
    //    FreshLikeDao.insertOne(f)
    //    FreshLikeDao.deleteOne(f2)
    //    FreshLikeDao.updateOne(f)
    //    FreshLikeDao.getById("user6") foreach(print(_))
    //    FreshLikeDao.getByUserId("user_") foreach(println(_))
    //

    /**
      * Fresh Operation
      */

    val fresh = new Fresh("", FreshTypeEnum.ORIGINAL,
      "ceshi","njxz_c","/v2/imgs", FreshStructTypeEnum.GRAPHIC,"",ViewTypeEnum.NORMAL,"",
      DateTime.now,10L,10L,20L,31L,15L,IsDeleteEnum.ENABLE,true,"","","")

//    FreshDao.getByFreshId("035480a9-3d0d-4bf1-802a-d6ea203d7cea") foreach(println(_))
    FreshDao.selectByOption(FreshQueryOption(notInFreshIds = List("01d7cd4a-7bee-448e-ad0c-954dc95468fa", "035480a9-3d0d-4bf1-802a-d6ea203d7cea")),RowBounds(0,100)) foreach(println(_))
  }
}
