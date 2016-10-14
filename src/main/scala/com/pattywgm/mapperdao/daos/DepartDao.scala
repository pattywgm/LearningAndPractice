package com.pattywgm.mapperdao.daos

import com.googlecode.mapperdao._
import com.googlecode.mapperdao.utils._
import com.pattywgm.mapperdao.models.{Depart, DepartEntity}
import com.twitter.util.Future

/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/10/13 下午7:39
  * Desc:
  */
class DepartDao(val mapperDao: MapperDao, val queryDao: QueryDao) extends NaturalStringIdCRUD[Depart] {

  import Query._
  import queryDao._

  val entity = DepartEntity

  // alias for DepartEntity
  val e = DepartEntity


  def selectDepart(departId: String, tenantId: String): Future[Option[Depart]] = {
    Future(query(select from e where e.departId === departId and e.tenantId === tenantId)).map(_.headOption)
  }

  def insDepart(depart: Depart): Future[Depart] = {
    Future {
      create(depart)
    }
  }

}
