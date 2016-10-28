package com.pattywgm.mybatis.daos

import com.pattywgm.mybatis.models.FreshLike
import com.pattywgm.mybatis.typehandler.DateTimeTypeHandler
import org.mybatis.scala.mapping.Binding._
import org.mybatis.scala.mapping._

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
        <xsql>select * from t_cpdaily_freshLikes where user_id =
          {"userId" ?}
        </xsql>
    }

  val getByUserId = new SelectListBy[String, FreshLike] {
    resultMap = FreshLikeMap

    def xsql =
      <xsql>
        {SELECT_SQL} where USER_ID LIKE
        {"userId" ?}
      </xsql>
  }

  val insertOne = new Insert[FreshLike] {
    def xsql =
      <xsql>
        insert into t_cpdaily_freshLikes(USER_ID, FRESH_ID, C_TIME) values (
        {"userId" ?}
        ,
        {"freshId" ?}
        ,
        NOW()
        )
      </xsql>
  }

  val deleteOne = new Delete[FreshLike] {
    def xsql =
      <xsql>
        delete from t_cpdaily_freshLikes where USER_ID=
        {"userId" ?}
        and FRESH_ID=
        {"freshId" ?}
      </xsql>
  }

  val updateOne = new Update[FreshLike] {
    def xsql =
      <xsql>
        update t_cpdaily_freshLikes set C_Time=NOW() WHERE USER_ID=
        {"userId" ?}
        and FRESH_ID=
        {"freshId" ?}
      </xsql>
  }


  def bind = Seq(findAll, getById, insertOne, deleteOne, updateOne, getByUserId)
}
