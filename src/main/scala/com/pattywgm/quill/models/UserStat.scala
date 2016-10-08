package com.pattywgm.quill.models

import java.util.UUID
import io.getquill.{CamelCase, CassandraAsyncContext}
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/9/30 下午4:58
  * Desc:
  */

case class UserStat(id: UUID, fansCount: Long, followCount: Long)

abstract class ConcreteUserStat(val ctx: CassandraAsyncContext[CamelCase]) {

  import ctx._

  val qUserStat = quote(query[UserStat].schema(_.entity("userstats")))

  /**
    * INSERT statements are not allowed on counter tables, use UPDATE instead
    *
    * @param userStat
    * @return
    */
  def update(userStat: UserStat) = {
    val ins = quote(qUserStat.filter(_.id == lift(userStat.id)).update(
      p => p.fansCount -> infix"${p.fansCount} + ${lift(userStat.fansCount)}",
      p => p.followCount -> (infix"${p.followCount} + ${lift(userStat.followCount)}")))
    ctx.run(ins)
  }
}
