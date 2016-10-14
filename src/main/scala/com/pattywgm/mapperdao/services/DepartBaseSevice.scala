package com.pattywgm.mapperdao.services

import com.pattywgm.mapperdao.models.Depart
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

  def selectDepart(departId: String, tenantId: String): Future[Option[Depart]] = {
    appDataBase.depart.selectDepart(departId, tenantId)
  }

  def insDepart(depart: Depart): Future[Depart] = {
    appDataBase.depart.insDepart(depart)
  }

}
