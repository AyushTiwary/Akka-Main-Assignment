package kip.knoldus

import kip.knoldus.models.{Account, Biller}

import scala.collection.mutable

object Database {

   val accountInfo: mutable.Map[String, Account] = mutable.Map("ertiwari" -> Account(10000L, "Tiwari", "Noida", "ertiwari", 5000),
    "erayush" -> Account(10001L, "Ayush", "Delhi", "erayush", 5000))

  val database: mutable.Map[Long, (Account, List[Biller])] = mutable.Map()

}