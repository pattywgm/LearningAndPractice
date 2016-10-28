package com.pattywgm.mybatis.models

import org.joda.time.DateTime

/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/10/20 下午4:38
  * Desc:
  */

class FreshLike {
  var userId : String = _
  var freshId : String = _
  var cTime : DateTime = _

  override def toString: String = {
    return ("userId: %s , freshId: %s, cTime: %s".format(userId, freshId, cTime))
  }
}

object FreshLike {

  def apply(cTime: DateTime) = {
    val freshLike = new FreshLike
    freshLike.cTime = cTime
    freshLike
  }
}