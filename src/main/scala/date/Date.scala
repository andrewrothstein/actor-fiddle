package date

case class Date(year: Int, month: MonthOfYear, day: Int = 1) {
  def julian = Date.julian(year, month, day)
  private lazy val dim = Date.daysInMonth(year, month)
  def eom = if (day == dim) this else Date(year, month, dim)
  override def toString = day + "-" + month + "-" + year
  def asYYYYMMDD = year * 10000 + month.asInt * 100 + day
}

object Date {

  def isLeapYear(year: Int) = if (year % 100 == 0) { year % 400 == 0 } else { year % 4 == 0 }

  def daysInYear(year: Int) = if (isLeapYear(year)) 366 else 365

  def daysInMonth(year: Int, month: MonthOfYear) = month match {
    case Feb => if (isLeapYear(year)) 29 else 28
    case Apr => 30
    case Jun => 30
    case Sep => 30
    case Nov => 30
    case _ => 31
  }

  private def daysFromYears(year :Int) = if (year > 0) (0 /: (0 to year - 1))(_ + daysInYear(_)) else 0

  private def daysFromMonths(year :Int, month :MonthOfYear) = if (month.asInt > 1) (0 /: (1 to month.asInt - 1))(_ + daysInMonth(year, _)) else 0
  
  private val julianDaysShortcutUpper = 5000
  private lazy val julianDaysShortcut = (0 to julianDaysShortcutUpper) map (s => daysFromYears(s)) toArray
  
  def julian(year :Int, month :MonthOfYear, day :Int) = {
    val dfy = if (year <= julianDaysShortcutUpper) julianDaysShortcut(year) else daysFromYears(year)
    val dfm = daysFromMonths(year, month)
//    println("year=" + year + ",month=" + month + ",day=" + day + " => " + dfy + " + " + dfm + " + " + day)
    dfy + dfm + day
  }
  
  def daysBetween(d1: Date, d2: Date) = d2.julian - d1.julian
}