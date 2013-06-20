case class Accrual(dc: DateCalc, start: Date, end: Date, rate: Double) {
  val alpha = dc.alpha(start, end)
  val effaccrual = alpha * rate
}