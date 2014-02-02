package date

case class Date(year: Int, month: MonthOfYear, day: Int = 1) {
  def julian = Date.julian(year, month, day)
 
  lazy val daysInMonth = Date.daysInMonth(year, month)
  lazy val daysLeftInMonth = daysInMonth - day
  
  lazy val daysInYear = Date.daysInYear(year)
  lazy val dayInYear = julian - Date.julian(year, Jan, 1) + 1
  lazy val daysLeftInYear = daysInYear - dayInYear

  lazy val isEOM = day == daysInMonth
  def eom = if (isEOM) this else Date(year, month, daysInMonth)
 
  override def toString = day + "-" + month + "-" + year
 
  def asYYYYMMDD = year * 10000 + month.asInt * 100 + day

  def subtractDays(i :Int) :Date = {
    if (i == 0)
      this
    else if (i < 0)
      addDays(-i)
    else if (i >= dayInYear)
      Date.EOY(year - 1).subtractDays(i - dayInYear)
    else if (i >= day)
      Date.EOM(year, MonthOfYear.previous(month)).subtractDays(i - day)
    else
      Date(year, month, day - i)
  }
  
  def addDays(i :Int) :Date = {
    if (i == 0)
      this
    else if (i < 0)
	  subtractDays(-i)
	else if (i >= daysLeftInYear)
	  Date(year + 1, Jan).addDays(i - daysLeftInYear - 1)
	else if (i > daysLeftInMonth)
	  Date(year, MonthOfYear.next(month)).addDays(i - daysLeftInMonth - 1)
	else
	  Date(year, month, day + i)
  }
  
  def firstOfMonth = {
    if (day == 1) { this } else { Date(year, month, 1) }
  }
  
  def addYears(i :Int) :Date = {
    if (i == 0) {
      this
    }
    else if (i < 0) {
      subtractYears(-i)
    }
    else {
      Date(year + i, month, day)
    }
  }
  
  def subtractYears(i :Int) :Date = {
    if (i == 0) {
      this
    }
    else if (i < 0) {
      addYears(-i)
    }
    else {
      Date(year - i, month, day)
    }
  }
  
  def subtractMonths(i :Int) :Date = {
    if (i == 0) {
      this
    }
    else if (i < 0) {
      addMonths(-i)
    }
    else if (i >= 12) {
      subtractYears(i / 12).subtractMonths(i % 12)
    }
    else if (i >= month.asInt) {
      Date(year - 1, 12 + month.asInt - i, day)
    }
    else {
      Date(year, month.asInt - i, day)
    }
  }

  def addMonths(i :Int) :Date = {
    if (i == 0) {
      this
    }
    else if (i < 0) {
      subtractMonths(-i)
    }
    else if (i >= 12) {
      addYears(i / 12).addMonths(i % 12)
    }
    else if (i + month.asInt > 12){
      Date(year + 1, i + month.asInt - 12, day)
    }
    else {
      Date(year, i + month.asInt, day)
    }
  }
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
  
  def isEOM(year :Int, month :MonthOfYear, day :Int) = day == daysInMonth(year, month)
  def EOM(year :Int, month :MonthOfYear) = Date(year, month, daysInMonth(year, month))

  def EOY(year :Int) = Date(year, Dec, 31)
  
  def julian(year :Int, month :MonthOfYear, day :Int) = {
    val dfy = if (year <= julianDaysShortcutUpper) julianDaysShortcut(year) else daysFromYears(year)
    val dfm = daysFromMonths(year, month)
//    println("year=" + year + ",month=" + month + ",day=" + day + " => " + dfy + " + " + dfm + " + " + day)
    dfy + dfm + day
  }
  
  def daysBetween(d1: Date, d2: Date) = d2.julian - d1.julian
  def monthsBetween(d1 :Date, d2 :Date) = 12 * (d2.year - d1.year) + (d2.month.asInt - d1.month.asInt)
}