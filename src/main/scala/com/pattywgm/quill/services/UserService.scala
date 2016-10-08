package com.pattywgm.quill.services

import com.pattywgm.quill.models.UserStat
import com.pattywgm.quill.modules.AppDataBase

/**
  * Version: 3.0
  * Author: pattywgm 
  * Time: 16/9/30 下午5:01
  * Desc:
  */
class UserService {
  val appDataBase: AppDataBase = new AppDataBase

  def update(userStat: UserStat) = {
    appDataBase.userCql.update(userStat)
  }

}
