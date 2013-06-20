object SimpleDate {
  val daysInNonLeapYearByMonth = Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 31, 31)
  val cumulativeDaysInNonLeapYearByMonth = daysInNonLeapYearByMonth.map((x) => x)
}

case class SimpleDate(year :Int, month :Int, day :Int) extends Date {
  override def julian = year * 365 + SimpleDate.cumulativeDaysInNonLeapYearByMonth[month]
}