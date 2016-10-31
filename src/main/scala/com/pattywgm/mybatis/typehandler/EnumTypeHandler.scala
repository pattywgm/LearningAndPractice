package com.pattywgm.mybatis.typehandler

import java.sql._

import com.pattywgm.mybatis.models.FreshStructTypeEnum._
import com.pattywgm.mybatis.models.IsDeleteEnum.IsDeleteE
import com.pattywgm.mybatis.models.ViewTypeEnum.ViewTypeE
import com.pattywgm.mybatis.models.{IsDeleteEnum, ViewTypeEnum, FreshStructTypeEnum, FreshTypeEnum}
import com.pattywgm.mybatis.models.FreshTypeEnum._
import org.apache.ibatis.`type`.JdbcType
import org.mybatis.scala.mapping.TypeHandler


/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/10/28 上午10:33
  * Desc: org.joda.time.DateTime的typehandler
  */

class FreshTypeHandler extends TypeHandler[FreshTypeE] {

  override def setParameter(ps: PreparedStatement, i: Int, parameter: FreshTypeE, jdbcType: JdbcType): Unit = {
    if (parameter != null) {
      ps.setString(i, parameter.toString)
    }
    else
      ps.setString(i, null)
  }

  override def getResult(rs: ResultSet, columnName: String): FreshTypeE = {
    val ts = rs.getString(columnName)
    if (ts != null)
      return FreshTypeEnum.withName(ts)
    else
      return null
  }

  override def getResult(rs: ResultSet, columnIndex: Int): FreshTypeE = {
    val ts = rs.getString(columnIndex)
    if (ts != null)
      return FreshTypeEnum.withName(ts)
    else
      return null
  }

  override def getResult(cs: CallableStatement, columnIndex: Int): FreshTypeE = {
    val ts = cs.getString(columnIndex)
    if (ts != null)
      return FreshTypeEnum.withName(ts)
    else
      return null
  }
}

class FreshStructTypeHandler extends TypeHandler[FreshStructTypeE] {

  override def setParameter(ps: PreparedStatement, i: Int, parameter: FreshStructTypeE, jdbcType: JdbcType): Unit = {
    if (parameter != null) {
      ps.setString(i, parameter.toString)
    }
    else
      ps.setString(i, null)
  }

  override def getResult(rs: ResultSet, columnName: String): FreshStructTypeE = {
    val ts = rs.getString(columnName)
    if (ts != null)
      return FreshStructTypeEnum.withName(ts)
    else
      return null
  }

  override def getResult(rs: ResultSet, columnIndex: Int): FreshStructTypeE = {
    val ts = rs.getString(columnIndex)
    if (ts != null)
      return FreshStructTypeEnum.withName(ts)
    else
      return null
  }

  override def getResult(cs: CallableStatement, columnIndex: Int): FreshStructTypeE = {
    val ts = cs.getString(columnIndex)
    if (ts != null)
      return FreshStructTypeEnum.withName(ts)
    else
      return null
  }
}

class ViewTypeHandler extends TypeHandler[ViewTypeE] {

  override def setParameter(ps: PreparedStatement, i: Int, parameter: ViewTypeE, jdbcType: JdbcType): Unit = {
    if (parameter != null) {
      ps.setString(i, parameter.toString)
    }
    else
      ps.setString(i, null)
  }

  override def getResult(rs: ResultSet, columnName: String): ViewTypeE = {
    val ts = rs.getString(columnName)
    if (ts != null)
      return ViewTypeEnum.withName(ts)
    else
      return null
  }

  override def getResult(rs: ResultSet, columnIndex: Int): ViewTypeE = {
    val ts = rs.getString(columnIndex)
    if (ts != null)
      return ViewTypeEnum.withName(ts)
    else
      return null
  }

  override def getResult(cs: CallableStatement, columnIndex: Int): ViewTypeE = {
    val ts = cs.getString(columnIndex)
    if (ts != null)
      return ViewTypeEnum.withName(ts)
    else
      return null
  }
}

class IsDeleteTypeHandler extends TypeHandler[IsDeleteE] {

  override def setParameter(ps: PreparedStatement, i: Int, parameter: IsDeleteE, jdbcType: JdbcType): Unit = {
    if (parameter != null) {
      ps.setString(i, parameter.toString)
    }
    else
      ps.setString(i, null)
  }

  override def getResult(rs: ResultSet, columnName: String): IsDeleteE = {
    val ts = rs.getString(columnName)
    if (ts != null)
      return IsDeleteEnum.withName(ts)
    else
      return null
  }

  override def getResult(rs: ResultSet, columnIndex: Int): IsDeleteE = {
    val ts = rs.getString(columnIndex)
    if (ts != null)
      return IsDeleteEnum.withName(ts)
    else
      return null
  }

  override def getResult(cs: CallableStatement, columnIndex: Int): IsDeleteE = {
    val ts = cs.getString(columnIndex)
    if (ts != null)
      return IsDeleteEnum.withName(ts)
    else
      return null
  }
}
