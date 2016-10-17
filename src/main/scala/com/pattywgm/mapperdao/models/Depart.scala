package com.pattywgm.mapperdao.models

import com.googlecode.mapperdao.{Entity, NaturalStringId, ValuesMap}
import org.joda.time.DateTime

/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/10/13 下午7:39
  * Desc:
  */
case class Depart(wid: String, departId: String, departName: String, departShortName: String = "", pDepartId: String = "",
                  tenantId: String, sortNo: Int = 0, updateTime: DateTime = DateTime.now)

case class DepartQueryOption(departIdPart: String = "", departId: String = "",
                             departIdNeed: Boolean = false, departIdPartNeed: Boolean = false)

object DepartEntity extends Entity[String, NaturalStringId, Depart]("T_CPDAILY_DEPARTS") {
  val wid = key("WID") to (_.wid)
  val departId = column("DEPART_ID") to (_.departId)
  val departName = column("DEPART_NAME") to (_.departName)
  val departShortName = column("DEPART_SHORT_NAME") to (_.departShortName)
  val pDepartId = column("P_DEPART_ID") to (_.pDepartId)
  val tenantId = column("TENANT_ID") to (_.tenantId)
  val sortNo = column("SORT_NO") to (_.sortNo)
  val updateTime = column("UPDATE_TIME") to (_.updateTime)


  def constructor(implicit m: ValuesMap) =
    new Depart(wid, departId, departName, departShortName, pDepartId, tenantId, sortNo, updateTime) with NaturalStringId

}