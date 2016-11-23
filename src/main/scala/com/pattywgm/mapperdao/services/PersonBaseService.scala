package com.pattywgm.mapperdao.services

import com.googlecode.mapperdao.NaturalStringId
import com.pattywgm.mapperdao.models.{House, Person}
import com.pattywgm.mapperdao.modules.AppDataBase
import com.twitter.util.Future

/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/11/22 下午6:27
  * Desc:
  */
class PersonBaseService {
  val appDataBase: AppDataBase = new AppDataBase

  def selectPerson(id: Int): Future[Option[Person]] = {
    appDataBase.person.selectPerson(id)
  }

  def deletePerson(id: Int): Future[Person] = {
    appDataBase.person.deletePerson(id)
  }

  def insertPerson(person: Person): Future[Person with NaturalStringId] = {
    appDataBase.person.insertPerson(person)
  }

  def updatePerson(person: Person): Future[Int] = {
    appDataBase.person.updatePerson(person)
  }

  def updatePersonAddr(person: Person): Future[House] = {
    appDataBase.person.updatePersonAddr(person)
  }

}
