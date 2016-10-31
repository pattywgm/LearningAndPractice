package com.pattywgm.mybatis.daos

import com.pattywgm.mybatis.models.Fresh
import com.pattywgm.mybatis.typehandler._
import org.mybatis.scala.mapping.Binding._
import org.mybatis.scala.mapping._

/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/10/28 下午5:30
  * Desc:
  */
object FreshDao {
  val FreshMap = new ResultMap[Fresh] {
    id(column = "fresh_id", property = "freshId")
    result(column = "fresh_Type", property = "freshType", typeHandler = T[FreshTypeHandler])
    result(column = "content", property = "content")
    result(column = "imgs", property = "imgs")
    result(column = "fresh_Struct_Type", property = "freshStructType",  typeHandler = T[FreshStructTypeHandler])
    result(column = "resource_Id", property = "resourceId")
    result(column = "resource_View_Type", property = "resourceViewType", typeHandler = T[ViewTypeHandler])
    result(column = "cUser_Id", property = "cUserId")
    result(column = "c_Time", property = "cTime", typeHandler = T[DateTimeTypeHandler])
    result(column = "collect_Num", property = "collectNum")
    result(column = "comment_Num", property = "commentNum")
    result(column = "forword_Num", property = "forwordNum")
    result(column = "read_Num", property = "readNum")
    result(column = "like_Num", property = "likeNum")
    result(column = "is_Delete", property = "isDelete", typeHandler = T[IsDeleteTypeHandler])
    result(column = "is_Recommend", property = "isRecommend")
    result(column = "reply_Fresh_Id", property = "replyFreshId")
    result(column = "reply_User_Id", property = "replyUserId")
    result(column = "p_Fresh_Id", property = "pFreshId")
  }

  val SELECT_SQL =
    <xsql>
      SELECT *
      FROM t_cpdaily_freshs
    </xsql>

  val getByFreshId = new SelectOneBy[String, Fresh] {
    resultMap = FreshMap

    def xsql =
      <xsql>
        {SELECT_SQL}
        where fresh_id=
        {"freshId" ?}
      </xsql>
  }

  def bind = Seq(getByFreshId)

}
