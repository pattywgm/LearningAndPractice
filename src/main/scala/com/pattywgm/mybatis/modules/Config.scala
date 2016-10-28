package com.pattywgm.mybatis.modules

/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/10/18 下午5:23
  * Desc:
  */


import com.pattywgm.mybatis.daos.FreshLikeDao
import org.mybatis.scala.config.Configuration

object Config {

  // Load datasource configuration
  val config = Configuration("mybatis.xml")

  // Create a configuration space, add the data access method
  config.addSpace("cpdailySpace") { space =>
    space ++= FreshLikeDao
  }

  // Build the session manager
  val persistenceContext = config.createPersistenceContext


}
