package com.pattywgm.quill.modules

import com.pattywgm.quill.models.{ConcreteUserStat, ConcreteCqlNews, ConcreteSqlNews}
import io.getquill.{CamelCase, CassandraAsyncContext, FinagleMysqlContext}

/**
  * Version: 1.1
  * Author: pattywgm 
  * Time: 16/9/14 下午2:12
  * Desc:
  */
class AppDataBase {
  lazy val mariadb: FinagleMysqlContext[CamelCase] = new FinagleMysqlContext[CamelCase]("mariadb")
  lazy val ctx: CassandraAsyncContext[CamelCase] = new CassandraAsyncContext[CamelCase]("dsc")

  object newsSql extends ConcreteSqlNews(mariadb)

  object newsCql extends ConcreteCqlNews(ctx)

  object userCql extends ConcreteUserStat(ctx)
}
