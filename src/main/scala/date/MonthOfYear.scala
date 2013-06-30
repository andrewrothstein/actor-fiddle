package date

sealed case class MonthOfYear(asInt :Int, abbrev :String) {
  override def toString = abbrev
}

object Jan extends MonthOfYear(1, "JAN")
object Feb extends MonthOfYear(2, "FEB")
object Mar extends MonthOfYear(3, "MAR")
object Apr extends MonthOfYear(4, "APR")
object May extends MonthOfYear(5, "MAY")
object Jun extends MonthOfYear(6, "JUN")
object Jul extends MonthOfYear(7, "JUL")
object Aug extends MonthOfYear(8, "AUG")
object Sep extends MonthOfYear(9, "SEP")
object Oct extends MonthOfYear(10, "OCT")
object Nov extends MonthOfYear(11, "NOV")
object Dec extends MonthOfYear(12, "DEC")

object MonthOfYear {
  implicit def fromInt(i :Int) :MonthOfYear = i match {
	  case 1 => Jan
	  case 2 => Feb
	  case 3 => Mar
	  case 4 => Apr
	  case 5 => May
	  case 6 => Jun
	  case 7 => Jul
	  case 8 => Aug
	  case 9 => Sep
	  case 10 => Oct
	  case 11 => Nov
	  case 12 => Dec
	  case _ => throw new IllegalArgumentException(i + " is not a valid month of the year")
  }
}
