package kip.knoldus.services

import kip.knoldus.Database
import kip.knoldus.Database.{accountInfo, database}
import kip.knoldus.models.{Account, Biller}

class BillerService {

  def payAmt(account: Account, biller: Biller): database.type = {

    Database.accountInfo += (account.username -> account.copy(initialAmount = account.initialAmount - biller.amountPaid))

    Database.database += (account.accountNumber -> (account.copy(initialAmount = account.initialAmount - biller.amountPaid),
      List(biller.copy(amountPaid = biller.amountPaid, totalPaidAmount = biller.totalPaidAmount + biller.amountPaid))))

  }

}
