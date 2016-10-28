package com.pattywgm.mybatis.daos

import com.pattywgm.mybatis.models.FreshLike
import com.pattywgm.mybatis.typehandler.DateTimeTypeHandler
import org.mybatis.scala.mapping.TypeHandlers.{OptTimestampTypeHandler, OptStringTypeHandler}
import org.mybatis.scala.mapping._
import org.mybatis.scala.mapping.Binding._

/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/10/20 下午4:38
  * Desc:
  */
object FreshLikeDao {

  val FreshLikeMap = new ResultMap[FreshLike] {
    id(column = "USER_ID", property = "userId")
    result(column = "FRESH_ID", property = "freshId")
    result(column = "C_TIME", property = "cTime", typeHandler = T[DateTimeTypeHandler])
  }

  val SELECT_SQL =
    <xsql>
      SELECT *
      FROM t_cpdaily_freshLikes
    </xsql>

  val findAll = new SelectList[FreshLike] {
    resultMap = FreshLikeMap
    def xsql = SELECT_SQL
  }

  val getById =
    new SelectOneBy[String, FreshLike] {
      resultMap = FreshLikeMap
      def xsql =
        <xsql> select * from t_cpdaily_freshLikes where user_id = {"userId"?} </xsql>
    }


  def bind = Seq(findAll, getById)
}
