package kip.knoldus.actors

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit}
import org.scalatest.{BeforeAndAfterAll, FunSuiteLike}
import org.scalatest.mock.MockitoSugar

class AccountGeneratorActorTest extends TestKit(ActorSystem("test-system")) with
          FunSuiteLike with BeforeAndAfterAll with ImplicitSender with MockitoSugar {



}
