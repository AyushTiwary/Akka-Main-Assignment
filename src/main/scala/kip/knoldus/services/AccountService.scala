package kip.knoldus.services

import kip.knoldus.Database
import kip.knoldus.Database.database
import kip.knoldus.models.Account

class AccountService{

  def addUser(userName: String, userAccount: Account): database.type = {

    Database.accountInfo += (userName -> userAccount)
    Database.database += (userAccount.accountNumber -> (userAccount, Nil))

  }

}
