trait DateCalc {
	def alpha(start :Date, end :Date) :Double
	def daysdiff(start :Date, end :Date) :Long
}

object DateCalc {
  val act = new DateCalc {
    override def alpha(start :Date, end :Date) = {
      daysdiff(start, end) / 365.0
    }
    override def daysdiff(start :Date, end :Date) =
      start.julian - end.julian
  }
}