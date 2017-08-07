package kip.knoldus.actors

import akka.actor.{Actor, ActorLogging}
import akka.dispatch.{BoundedMessageQueueSemantics, RequiresMessageQueue}
import kip.knoldus.Database
import kip.knoldus.models.Account
import kip.knoldus.services.AccountService

class AccountGeneratorActor(accountService: AccountService) extends Actor with
  ActorLogging with RequiresMessageQueue[BoundedMessageQueueSemantics]{

  override def receive: Receive = {

    case account : Account =>
      self ! uniqueUser(account.username, account)

    case _ => log.info("Invalid Call")

  }

  def uniqueUser(username : String, account : Account): Unit ={

     if(Database.accountInfo.contains(username)){
      log.error("Username already exists")
    }

     else{
      log.info("Your request is accepted")
       sender() ! accountService.addUser(username,account)

    }

  }

}
