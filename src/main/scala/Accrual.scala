import date.DateCalc
import date.Date

case class Accrual(dc: DateCalc, start: Date, end: Date, rate: Double) {
  lazy val alpha = dc.alpha(start, end)
  lazy val effaccrual = alpha * rate
}

object Accrual {

  def monthly(dc :DateCalc, start :Date, rate :Double) = {
    val fom = start.firstOfMonth
    Accrual(dc, fom, fom.addMonths(1), rate)
  }

  def monthly(dc :DateCalc, start :Date, rate :Double, periods :Int) :List[Accrual] = {
    periods match {
      case 0 => List[Accrual]()
      case _ => monthly(dc, start, rate) :: monthly(dc, start.addMonths(1), rate, periods - 1)
    }
  }
}