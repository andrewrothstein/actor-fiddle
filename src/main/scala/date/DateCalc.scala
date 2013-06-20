package date

import Date._

trait DateCalc {
  def alpha(start: Date, end: Date): Double
}

object ActAct extends DateCalc {
  override def alpha(start: Date, end: Date) = daysBetween(start, end) / 365.0
}
