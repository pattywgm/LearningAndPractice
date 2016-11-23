package com.pattywgm.mapperdao

import java.util.UUID

import com.pattywgm.mapperdao.models.{House, Person, DepartQueryOption, Depart}
import com.pattywgm.mapperdao.services.{PersonBaseService, DepartBaseSevice}
import org.joda.time.DateTime

/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/10/14 上午11:19
  * Desc:
  */
object mainMapperDemoTest extends App{
//  val departService: DepartBaseSevice = new DepartBaseSevice

//  departService.insDepart(new Depart(UUID.randomUUID().toString, "01", "招生办", "","","njxz",0,DateTime.now)).map{
//    depart => departService.selectDepart("01", "njxz").map{
//      case Some(de) => print(de)
//      case None => throw new Exception("Depart inserted but not found!")
//    }
//  }

//  departService.selectDepart("01", "njxz").map{
//    case Some(de) => print("院系名: "+de.departName)
//    case None => throw new Exception("Depart inserted but not found!")
//  }

//  departService.selectByOption("njxz", DepartQueryOption(departIdPartNeed = false, departIdPart = "02", departIds = Seq("0201", "020102"))).map{
//    departs => departs.foreach(println(_))
//  }
  val personService: PersonBaseService = new PersonBaseService

//  personService.insertPerson(Person(1, "mzp", 27, Set(House(1,"铁心桥"), House(2, "翠屏山")))).map{
//    person => println(person.name + "->" + person.houses.foreach(p => println(p.address)))
//  }

  personService.updatePersonAddr(Person(1, "mzp", 27, Set(House(1, "Tie"), House(2,"Cui"))))

}
