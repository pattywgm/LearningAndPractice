package com.pattywgm.mybatis.models

/**
 * Version: 1.1
 * Author: pattywgm
 * Time: 16/9/23 上午9:41
 * Desc:
 */

// circle
object CircleTypeEnum extends Enumeration {
  type CircleTypeE = Value
  val PHYSICAL, VIRTUAL = Value
}

object DisplayTypeEnum extends Enumeration {
  type DisplayTypeE = Value
  val VIDEO, NEWS, LIVE, NORMAL = Value
}

object DataSrcTypeEnum extends Enumeration {
  type DataSrcTypeE = Value
  val RECOMMEND, NORMAL, ALL, FOCUS,VIDEO, LIVE, NEWS = Value
}


// fresh
object FreshTypeEnum extends Enumeration {
  type FreshTypeE = Value
  val ORIGINAL, COMMENT = Value
}

object FreshStructTypeEnum extends Enumeration {
  type FreshStructTypeE = Value
  val GRAPHIC, REFER = Value
}

object IsDeleteEnum extends Enumeration {
  type IsDeleteE = Value
  val ENABLE, DISABLE, ADMINDISABLE = Value
}

// resource
object ViewTypeEnum extends Enumeration {
  type ViewTypeE = Value
  val VIDEO, LIVE, NEWS,NORMAL = Value
}

object LiveStatusEnum extends Enumeration {
  type LiveStatusE = Value
  val LIVE, LIVEIN, LIVEEND = Value
}

object VideoTypeEnum extends Enumeration {
  type VideoTypeE = Value
  val YOUKU, MEIPAI = Value
}

object ContentSrcTypeEnum extends Enumeration {
  type ContentSrcTypeE = Value
  val ORIGINAL, LINK = Value
}

// tenant
object TenantJoinTypeEnum extends Enumeration {
  type TenantJoinTypeE = Value
  val CLOUD, NOTCLOUD = Value
}

// user
object GenderEnum extends Enumeration {
  type GenderE = Value
  val MALE, FEMALE, UNKNOWN = Value
}

object UserTypeEnum extends Enumeration {
  type UserTypeE = Value
  val STUDENT, TEACHER, MEDIA, SCHOOLMATE, TEMP, FRESHMATE = Value
}

object UserSrcTypeEnum extends Enumeration {
  type UserSrcTypeE = Value
  val IDS, MEDIA = Value
}

object ToggleEnum extends Enumeration {
  type ToggleE = Value
  val DO, UNDO = Value
}

object FreshSortEnum extends Enumeration {
  type FreshSortE = Value
  val TIME_ASC, TIME_DESC,COMMENT_DESC,LIKE_NUM_DESC = Value
}

object RelationEnum extends Enumeration {
  type RelationE = Value
  val FANS, IDOLS = Value
}


object FocusEnum extends Enumeration {
  type FocusE = Value
  val UN_FOCUS,FOCUS,EACH_FOCUS = Value
}
