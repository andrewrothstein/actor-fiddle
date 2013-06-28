package date

case class Date(year: Int, month: Int, day: Int = 1) {
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

  private def daysFromYears(year :Int) = if (year > 0) (0 /: (0 to year - 1))(_ + daysInYear(_)) else 0

  private def daysFromMonths(year :Int, month :Int) = if (month > 1) (0 /: (1 to month - 1))(_ + daysInMonth(year, _)) else 0
  
  private val julianDaysShortcutUpper = 5000
  private lazy val julianDaysShortcut = (0 to julianDaysShortcutUpper) map (s => daysFromYears(s)) toArray
  
  def julian(year :Int, month :Int, day :Int) = {
    val dfy = if (year <= julianDaysShortcutUpper) julianDaysShortcut(year) else daysFromYears(year)
    val dfm = daysFromMonths(year, month)
//    println("year=" + year + ",month=" + month + ",day=" + day + " => " + dfy + " + " + dfm + " + " + day)
    dfy + dfm + day
  }
  
  def daysBetween(d1: Date, d2: Date) = d2.julian - d1.julian
}