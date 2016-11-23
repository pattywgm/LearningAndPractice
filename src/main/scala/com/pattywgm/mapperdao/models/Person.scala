package com.pattywgm.mapperdao.models

import com.googlecode.mapperdao.{Entity, NaturalStringId, ValuesMap}

/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/11/22 下午5:27
  * Desc: oneToMany -> one
  */
case class Person(id: Int, name: String, age: Int, houses: Set[House])

object PersonEntity extends Entity[String, NaturalStringId, Person]("person") {
  val id = key("id") to (_.id)
  val name = column("name") to (_.name)
  val age = column("age") to (_.age)
  val houses = onetomany(HouseEntity) to (_.houses)

  def constructor(implicit m: ValuesMap) =
    new Person(id, name, age, houses) with NaturalStringId
}