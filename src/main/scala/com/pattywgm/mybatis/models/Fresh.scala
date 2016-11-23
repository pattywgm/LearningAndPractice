package com.pattywgm.mybatis.models

import com.pattywgm.mybatis.models.FreshStructTypeEnum.FreshStructTypeE
import com.pattywgm.mybatis.models.FreshTypeEnum.FreshTypeE
import com.pattywgm.mybatis.models.IsDeleteEnum.IsDeleteE
import com.pattywgm.mybatis.models.ViewTypeEnum.ViewTypeE
import org.joda.time.DateTime

/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/10/28 下午5:11
  * Desc:
  */
class Fresh {
  var freshId: String = _
  var freshType: FreshTypeE = FreshTypeEnum.ORIGINAL
  var content: String = _
  var imgs: String = _
  var freshStructType: FreshStructTypeE = FreshStructTypeEnum.GRAPHIC
  var resourceId: String = _
  var resourceViewType: ViewTypeE = ViewTypeEnum.NORMAL
  var cUserId: String = _
  var cTime: DateTime = _
  var collectNum: Long = _
  var commentNum: Long = _
  var forwordNum: Long = _
  var likeNum: Long = _
  var readNum: Long = _
  var isDelete: IsDeleteE = IsDeleteEnum.ENABLE
  var isRecommend: Boolean = false
  var replyFreshId: String = _
  var replyUserId: String = _
  var pFreshId: String = _

  def this(freshId: String, freshType: FreshTypeE, content: String, circleId: String, imgs: String, freshStructType: FreshStructTypeE,
           resourceId: String, resourceViewType: ViewTypeE, cUserId: String, cTime: DateTime, collectNum: Long, commentNum: Long, forwordNum: Long, likeNum: Long,
           readNum: Long, isDelete: IsDeleteE, isRecommend: Boolean, replyFreshId: String, replyUserId: String, pFreshId: String) {
    this()
    this.freshId = freshId
    this.freshType = freshType
    this.content = content
    this.imgs = imgs
    this.freshStructType = freshStructType
    this.resourceId = resourceId
    this.resourceViewType = resourceViewType
    this.cUserId = cUserId
    this.cTime = cTime
    this.collectNum = collectNum
    this.commentNum = commentNum
    this.forwordNum = forwordNum
    this.likeNum = likeNum
    this.readNum = readNum
    this.isDelete = isDelete
    this.isRecommend = isRecommend
    this.replyFreshId = replyFreshId
    this.replyUserId = replyUserId
    this.pFreshId = pFreshId
  }

  override def toString: String = {
    return ("freshId: %s, freshType: %s, content: %s, cTime: %s".format(freshId, freshType, content, cTime))
  }

}

object Fresh {

  def apply(freshId: String, freshType: FreshTypeE, content: String, circleId: String, imgs: String, freshStructType: FreshStructTypeE,
            resourceId: String, resourceViewType: ViewTypeE, cUserId: String, cTime: DateTime, collectNum: Long, commentNum: Long, forwordNum: Long, likeNum: Long,
            readNum: Long, isDelete: IsDeleteE, isRecommend: Boolean, replyFreshId: String, replyUserId: String, pFreshId: String): Unit = {

    new Fresh(freshId, freshType, content, circleId, imgs, freshStructType,
      resourceId, resourceViewType, cUserId, cTime, collectNum, commentNum, forwordNum, likeNum,
      readNum, isDelete, isRecommend, replyFreshId, replyUserId, pFreshId)
  }
}

case class FreshQueryOption(notInFreshIds: Seq[String] = Seq.empty, freshType: String = "",
                            inFreshIds: String = "", circleId: String = "", pFreshId: String = "",
                            isRecommend: Boolean = false, circleIds: String = "",
                            sortInfo: String = "", limits: Int = 10, offset: Int = 0,
                            isDelete: Seq[String] = Seq("ENABLE"),
                            cUserIds: Seq[String] = Seq.empty,
                            resourceViewType: Seq[String] = Seq.empty, lastTimeValue: Long = 0L)