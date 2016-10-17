package com.pattywgm.mapperdao.daos

import com.googlecode.mapperdao._
import com.googlecode.mapperdao.utils._
import com.pattywgm.mapperdao.models.{Depart, DepartEntity, DepartQueryOption}
import com.twitter.util.Future

/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/10/13 下午7:39
  * Desc:
  */
abstract class DepartDao(val mapperDao: MapperDao, val queryDao: QueryDao) extends NaturalStringIdCRUD[Depart] {

  import Query._
  import queryDao._

  val entity = DepartEntity

  // alias for DepartEntity
  val e = DepartEntity


  def selectDepart(departId: String, tenantId: String): Future[Option[Depart with NaturalStringId]] = {
    Future(query(select from e where e.departId === departId and e.tenantId === tenantId)).map(_.headOption)
  }

  def insDepart(depart: Depart): Future[Depart with NaturalStringId] = {
    Future {
      val inserted = mapperDao.insert(DepartEntity, depart)
      println("%d : %s", inserted.wid, inserted)
      inserted
    }
  }

  def selectByOption(tenantId: String, option: DepartQueryOption): Future[Seq[Depart]] = {
    Future {
      var q1 = select from e where e.tenantId === tenantId

      q1 = option.departIdPartNeed match {
        case true => option.departIdPart.nonEmpty match {
          case true => q1 and (e.departId like (option.departIdPart + "__"))
          case false => q1 and (e.departId like ("__"))
        }
        case false => q1
      }

      q1 = option.departIdNeed match {
        case true => q1.and(e.departId === option.departId)
        case false => q1
      }
      query(q1)
    }
  }

}
