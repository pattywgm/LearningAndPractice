package com.pattywgm.mapperdao.models

import com.googlecode.mapperdao.{Entity, NaturalStringId, ValuesMap}

/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/11/22 下午5:27
  * Desc: oneToMany -> many
  */
case class House(id: Int, address: String)

object HouseEntity extends Entity[String, NaturalStringId, House]("house") {
  val id = key("id") to (_.id)
  val address = column("address") to (_.address)

  def constructor(implicit m: ValuesMap) =
    new House(id, address) with NaturalStringId
}
