package com.pattywgm.mapperdao.models

import com.googlecode.mapperdao.{NaturalStringId, ValuesMap, Entity}
import org.joda.time.DateTime

/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/10/13 下午7:39
  * Desc:
  */
case class Depart(wid: String, departId: String, departName: String, departShortName: String = "", pDepartId: String = "",
                  tenantId: String, sortNo: Int = 0, updateTime: DateTime = DateTime.now)

object DepartEntity extends Entity[String, NaturalStringId, Depart]("t_cpdaily_departs")
{
  val wid = key("wid") to (_.wid)
  val departId = column("departId") to (_.departId)
  val departName = column("departName") to (_.departName)
  val departShortName = column("departShortName") to (_.departShortName)
  val pDepartId = column("pDepartId") to (_.pDepartId)
  val tenantId = column("tenantId") to (_.tenantId)
  val sortNo = column("sortNo") to (_.sortNo)
  val updateTime = column("updateTime") to (_.updateTime)


  def constructor(implicit m: ValuesMap) =
    new Depart(wid, departId, departName, departShortName, pDepartId, tenantId, sortNo, updateTime) with NaturalStringId

}