package com.pattywgm.mybatis.typehandler

import java.sql._

import org.apache.ibatis.`type`.JdbcType
import org.joda.time.{DateTime, DateTimeZone}
import org.mybatis.scala.mapping.TypeHandler


/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/10/28 上午10:33
  * Desc: org.joda.time.DateTime的typehandler
  */
class DateTimeTypeHandler extends TypeHandler[DateTime] {

  override def setParameter(ps: PreparedStatement, i: Int, parameter: DateTime, jdbcType: JdbcType): Unit = {
    if (parameter != null) {
      ps.setTimestamp(i, new Timestamp(parameter.getMillis))
    }
    else
      ps.setTimestamp(i, new Timestamp(DateTime.now.getMillis))
  }

  override def getResult(rs: ResultSet, columnName: String): DateTime = {
    val ts = rs.getTimestamp(columnName)
    if (ts != null)
      return new DateTime(ts.getTime(), DateTimeZone.UTC)
    else
      return null
  }

  override def getResult(rs: ResultSet, columnIndex: Int): DateTime = {
    val ts = rs.getTimestamp(columnIndex)
    if (ts != null)
      return new DateTime(ts.getTime(), DateTimeZone.UTC)
    else
      return null
  }

  override def getResult(cs: CallableStatement, columnIndex: Int): DateTime = {
    val ts = cs.getTimestamp(columnIndex)
    if (ts != null)
      return new DateTime(ts.getTime(), DateTimeZone.UTC)
    else
      return null
  }
}
