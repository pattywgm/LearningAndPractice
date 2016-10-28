package com.pattywgm.mybatis

import com.pattywgm.mybatis.daos.FreshLikeDao
import com.pattywgm.mybatis.modules.Config

/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/10/20 下午5:07
  * Desc:
  */
object MybatisMainTest extends App{
  val db = Config.persistenceContext

  db.transaction { implicit session =>
    FreshLikeDao.getById("03c5c47d-8d0b-4687-b76d-b33e8319ab68") foreach(print(_))
  }
}
