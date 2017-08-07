package kip.knoldus

import akka.actor.{ActorSystem, Props}
import kip.knoldus.actors.AccountGeneratorActor
import kip.knoldus.services.AccountService

object Main extends App{

  val accountService = new AccountService
  val system = ActorSystem("AccountGenerator")
  val accountGeneratorRef = system.actorOf(Props(classOf[AccountGeneratorActor], accountService))

}
