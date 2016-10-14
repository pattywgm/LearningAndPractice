package com.pattywgm.mapperdao

import java.util.UUID

import com.pattywgm.mapperdao.models.Depart
import com.pattywgm.mapperdao.services.DepartBaseSevice
import org.joda.time.DateTime

/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/10/14 上午11:19
  * Desc:
  */
object mainMapperDemoTest extends App{
  val departService: DepartBaseSevice = new DepartBaseSevice

  departService.insDepart(new Depart(UUID.randomUUID().toString, "01", "校长办公室", "","","njxz",0,DateTime.now)).map{
    depart => departService.selectDepart("01", "njxz").map{
      case Some(de) => print(de)
      case None => throw new Exception("Depart inserted but not found!")
    }
  }

}
