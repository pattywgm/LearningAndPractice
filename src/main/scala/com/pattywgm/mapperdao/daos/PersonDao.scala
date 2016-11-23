package com.pattywgm.mapperdao.daos

import com.googlecode.mapperdao.utils.{Helpers, NaturalStringIdCRUD}
import com.googlecode.mapperdao._
import com.pattywgm.mapperdao.models.{House, HouseEntity, PersonEntity, Person}
import com.twitter.util.Future

/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/11/22 下午5:51
  * Desc:
  */
abstract class PersonDao(val mapperDao: MapperDao, val queryDao: QueryDao) extends NaturalStringIdCRUD[Person] {
  import Query._
  import queryDao._

  val entity = PersonEntity
  val e = entity

  // 此处级联插入House数据
  def insertPerson(person: Person): Future[Person with NaturalStringId] = {
    Future{
      mapperDao.insert(PersonEntity, person)
    }
  }

  def selectPerson(id: Int): Future[Option[Person]] = {
    Future{
      query(select from e where e.id === id)
    }.map(_.headOption)
  }

  def updatePerson(person: Person): Future[Int] = {
    Future{
      (Update.update(e)
        set(e.age === person.age,
        e.name === person.name)
        where(e.id === person.id)).run(queryDao).rowsAffected
    }
  }

  // 可级联更新
  def updatePersonAddr(person: Person): Future[House] = {
    Future{
      val loaded = query(select from e where e.id === person.id).head
      val house = loaded.houses.find(_.id == 1).get
      mapperDao.update(HouseEntity, Helpers.asNaturalStringId(house), person.houses.find(_.id ==1).get)
    }
  }

  // 级联删除house数据
  def deletePerson(id: Int): Future[Person] = {
    Future{
      val loaded = query(select from e where e.id === id).head
      mapperDao.delete(DeleteConfig(true),PersonEntity, loaded)
    }
  }
}
