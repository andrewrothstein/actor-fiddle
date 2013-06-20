package date

trait DateCalc {
  def alpha(start: Date, end: Date): Double
}

object DateCalc {
  object ActAct extends DateCalc {
    override def alpha(start: Date, end: Date) = Date.daysBetween(start, end) / 365.0
  }
}
