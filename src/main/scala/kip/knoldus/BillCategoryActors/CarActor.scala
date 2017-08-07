package kip.knoldus.BillCategoryActors

import akka.actor.{Actor, ActorLogging}
import kip.knoldus.models.{Account, Biller}
import kip.knoldus.services.BillerService

class CarActor(billerService: BillerService, biller: Biller) extends Actor with ActorLogging {

  override def receive: PartialFunction[Any, Unit] = {
    case account: Account =>
      self ! getCarBill(account)
  }

  def getCarBill(account: Account): Unit = {
    sender() ! billerService.payAmt(account, biller)
    log.info("car bill has been paid ")
  }

}
