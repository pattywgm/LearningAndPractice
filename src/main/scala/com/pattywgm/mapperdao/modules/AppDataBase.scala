package com.pattywgm.mapperdao.modules

import java.util.Properties

import com.googlecode.mapperdao.utils.Setup
import com.pattywgm.mapperdao.daos.DepartDao
import com.pattywgm.mapperdao.models.DepartEntity
import org.apache.commons.dbcp2.BasicDataSourceFactory

/**
  * Version: 1.1
  * Author: pattywgm 
  * Time: 16/9/14 下午2:12
  * Desc:
  */
class AppDataBase {
  val properties = new Properties
  properties.load(getClass.getResourceAsStream("/application.properties"))

  val dataSource = BasicDataSourceFactory.createDataSource(properties)

  val (jdbc, mapperDao, queryDao, txManager) = Setup.oracle(dataSource,
    List(DepartEntity)
  )

  object depart extends DepartDao(mapperDao, queryDao)

//   jdbc 简单操作
//  val connection = dataSource.getConnection
//  val res = connection.createStatement().executeQuery("select table_name from user_tables")
//  while(res.next()) {
//    println(res.getString("table_name"))
//  }
}
