package date

case class Date(year: Int, month: Int, day: Int) {
  def julian = Date.julian(year, month, day)
}

object Date {

  def isLeapYear(year: Int) = if (year % 100 == 0) { year % 400 == 0 } else { year % 4 == 0 }

  def daysInYear(year: Int) = if (isLeapYear(year)) 366 else 365

  def daysInMonth(year: Int, month: Int) = month match {
    case 2 => if (isLeapYear(year)) 29 else 28
    case 4 => 30
    case 6 => 30
    case 9 => 30
    case 11 => 30
    case _ => 31
  }

  def julian(year: Int, month: Int, day: Int) = {
    val daysFromYears = if (year > 0) (0 /: (0 to year - 1))(_ + daysInYear(_)) else 0
    val daysFromMonths = if (month > 1) (0 /: (0 to month - 1))(_ + daysInMonth(year, _)) else 0
    daysFromYears + daysFromMonths + day
  }

  def daysBetween(d1: Date, d2: Date) = d2.julian - d1.julian
}