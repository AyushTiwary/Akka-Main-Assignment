package kip.knoldus.actors

import akka.actor.{Actor, ActorLogging}
import akka.dispatch.{BoundedMessageQueueSemantics, RequiresMessageQueue}
import kip.knoldus.Database
import kip.knoldus.models.{Account, CustomerInfo}
import kip.knoldus.services.AccountService

class AccountGeneratorActor(accountService: AccountService) extends Actor with
  ActorLogging with RequiresMessageQueue[BoundedMessageQueueSemantics]{

  var accNo = 1000

  override def receive: Receive = {

    case customerInfo: CustomerInfo =>

      accNo +=1
      val account = Account(accNo, customerInfo.accountHolderName, customerInfo.address,
      customerInfo.username, customerInfo.initialAmount)

      self ! uniqueUser(customerInfo.username, account)

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
