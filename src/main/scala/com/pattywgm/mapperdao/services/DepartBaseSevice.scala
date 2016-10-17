package com.pattywgm.mapperdao.services

import com.googlecode.mapperdao.NaturalStringId
import com.pattywgm.mapperdao.models.{DepartQueryOption, Depart}
import com.pattywgm.mapperdao.modules.AppDataBase
import com.twitter.util.Future

/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/10/14 上午11:00
  * Desc:
  */
class DepartBaseSevice {
  val appDataBase: AppDataBase = new AppDataBase

  def selectDepart(departId: String, tenantId: String): Future[Option[Depart with NaturalStringId]] = {
    appDataBase.depart.selectDepart(departId, tenantId)
  }

  def insDepart(depart: Depart): Future[Depart with NaturalStringId] = {
    appDataBase.depart.insDepart(depart)
  }

  def selectByOption(tenantId: String, option: DepartQueryOption): Future[Seq[Depart]] = {
    appDataBase.depart.selectByOption(tenantId, option)
  }

}
