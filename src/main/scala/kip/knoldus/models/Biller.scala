package kip.knoldus.models

case class Biller(billerCategory: String, billerName: String, accountNumber: Long, date: String, amountPaid: Float,
                  totalPaidAmount: Float, totalIterations: Int = 0, executedIterations: Int=0)
