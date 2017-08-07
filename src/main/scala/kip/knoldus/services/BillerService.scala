package kip.knoldus.services

import kip.knoldus.Database
import kip.knoldus.Database.database
import kip.knoldus.models.{Account, Biller}

class BillerService {

  def payAmt(account: Account, biller: Biller): database.type = {

    Database.database += (account.accountNumber -> (account.copy(initialAmount = account.initialAmount - biller.amountPaid),
      List(biller.copy(amountPaid = biller.amountPaid, totalPaidAmount = biller.totalPaidAmount + biller.amountPaid))))
  }

}
