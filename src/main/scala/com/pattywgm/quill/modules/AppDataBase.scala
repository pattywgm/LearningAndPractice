package com.pattywgm.quill.modules

import java.io.File
import com.pattywgm.quill.models.{ConcreteCqlNews, ConcreteSqlNews, ConcreteUserStat}
import com.typesafe.config.ConfigFactory
import io.getquill.{CassandraContextConfig, CamelCase, CassandraAsyncContext, FinagleMysqlContext}

/**
  * Version: 1.1
  * Author: pattywgm 
  * Time: 16/9/14 下午2:12
  * Desc:
  */
class AppDataBase {

  // load configurations from local file
  val parsedConfig = ConfigFactory.parseFile(new File("/Users/pattywgm/SelfProject/LearningAndPractice/src/main/resources/application.properties"))
  val conf = ConfigFactory.load(parsedConfig)
  val ctxConfig = new CassandraContextConfig(conf.getConfig("csx"))
  ctxConfig.builder.addContactPoint("127.0.0.2")
  val ctx: CassandraAsyncContext[CamelCase] = new CassandraAsyncContext[CamelCase](ctxConfig)

  lazy val mariadb: FinagleMysqlContext[CamelCase] = new FinagleMysqlContext[CamelCase](conf.getConfig("mdb"))

  /**
    * // load configurations from class path
    * lazy val mariadb: FinagleMysqlContext[CamelCase] = new FinagleMysqlContext[CamelCase]("mdb")
    * lazy val ctx: CassandraAsyncContext[CamelCase] = new CassandraAsyncContext[CamelCase]("csx")
    */
//  val cluster = Cluster.builder().addContactPoints("127.0.0.1", "127.0.0.2").build()


  object newsSql extends ConcreteSqlNews(mariadb)

  object newsCql extends ConcreteCqlNews(ctx)

  object userCql extends ConcreteUserStat(ctx)

}
