import Finance._

case class ScheduledFlow(
    accrual :Accrual,
    payDay :PayDate,
    beginBal :Double,
    principal :Double,
    interest :Double
) {
	val endBal = beginBal - principal
}

object ScheduledFlow {

  def amortizingFlow(accrual :Accrual, payDay :PayDate, beginBal: Double, remainingTerm: Double, rate: Double) = {
    val perInt = rate / 12.0
    val schedPmt = amortizationPayment(beginBal, perInt, remainingTerm)
    val schedInt = beginBal * perInt
    val schedPrin = schedPmt - schedInt
    ScheduledFlow(accrual, payDay, beginBal, schedPrin, schedInt)
  }
  
  def ioFlow(accrual :Accrual, payDay :PayDate, beginBal :Double, remainingTerm :Double, rate :Double) = {
    ScheduledFlow(accrual, payDay, beginBal, 0, beginBal * rate / 12.0)
  }
}