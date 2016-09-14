package com.wisedu.next

import com.twitter.finagle.redis.Client
import com.twitter.finagle.redis.util._
import com.twitter.util.Await

/**
  * Version: 1.1
  * Author: pattywgm 
  * Time: 16/9/14 上午10:13
  * Desc: Finagle-Redis Operation Demo
  */
object FinagleRedisOperationDemo extends App {

  lazy val redisClient = Client("127.0.0.1:6379")

  // simple set and get
  val setAndGetName = redisClient.set(StringToBuf("name"), StringToBuf("Jakie")).flatMap {
    case _ => redisClient.get(StringToBuf("name")) onSuccess {
      case Some(value) => println("The value of name is '" + BufToString(value) + "'")
      case None => println("Get no value, there is some error.")
    } onFailure {
      case e: Exception =>
        println("Exception: " + e.getMessage)
    }
  }

  Await.ready(setAndGetName)


  // list operation
  val setAndGetGoods = redisClient.lPush(StringToChannelBuffer("goods"),
    List(StringToChannelBuffer("moon cake"), StringToChannelBuffer("banana"))).flatMap {
    case _ => redisClient.lRange(StringToChannelBuffer("goods"), 0L, 15L) onSuccess {
      items =>
        CBToString.fromList(items).map {
          item => println("Goods: " + item)
        }
    } onFailure {
      case e: Exception =>
        println("Exception: " + e.getMessage)
    }
  }

  Await.all(setAndGetGoods)

  val delGoods = redisClient.lPop(StringToChannelBuffer("goods")).flatMap {
    case _ =>
      redisClient.lRem(StringToChannelBuffer("goods"), 3L, StringToChannelBuffer("banana")) onSuccess {
        case _ => println("Success remove")
      } onFailure {
        case e: Exception =>
          println("Exception: " + e.getMessage)
      }
  }

  Await.all(delGoods)

  // set operation

  val setAndGetBooks = redisClient.sAdd(StringToChannelBuffer("books"),
    List(StringToChannelBuffer("Hali"), StringToChannelBuffer("Netty"),
      StringToChannelBuffer("Java"), StringToChannelBuffer("Hali"))).flatMap {
    case _ => redisClient.sMembers(StringToChannelBuffer("books")) onSuccess {
      items => CBToString.fromList(items.toList).map {
        item => println("Book: " + item)
      }
    } onFailure {
      case e: Exception =>
        println("Exception: " + e.getMessage)
    }
  }

  Await.all(setAndGetBooks)

  // map operation
  val setAndGetUsers = redisClient.hMSet(StringToChannelBuffer("user:1"),
    Map(StringToChannelBuffer("name") -> StringToChannelBuffer("Patty"),
      StringToChannelBuffer("age") -> StringToChannelBuffer("17"),
      StringToChannelBuffer("gender") -> StringToChannelBuffer("female"))).flatMap{
    case _  => redisClient.hMGet(StringToChannelBuffer("user:1"), List(StringToChannelBuffer("name"),
      StringToChannelBuffer("age"), StringToChannelBuffer("gender"))) onSuccess{
      items => CBToString.fromList(items).map{
        item => println(item)
      }
    } onFailure {
      case e: Exception =>
        println("Exception: " + e.getMessage)
    }
  }

  Await.result(setAndGetUsers)


}
