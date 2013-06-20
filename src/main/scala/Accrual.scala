import date.DateCalc
import date.Date

case class Accrual(dc: DateCalc, start: Date, end: Date, rate: Double) {
  lazy val alpha = dc.alpha(start, end)
  lazy val effaccrual = alpha * rate
}