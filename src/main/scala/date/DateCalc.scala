package date

trait DateCalc {
  def daysPerYear :Double
  def daysBetween(start :Date, end :Date) :Int
  def alpha(start: Date, end: Date) = daysBetween(start, end) / daysPerYear
}

object DateCalc {
  object ActAct extends DateCalc {
    override def daysPerYear = 365
    override def daysBetween(start: Date, end: Date) = Date.daysBetween(start, end)
  }
  
  object D30360 extends DateCalc {
    override def daysPerYear = 360
    override def daysBetween(start :Date, end :Date) = {
      val dayAdj = if (start.isEOM && end.isEOM) 0 else end.day - start.day 
      30 * Date.monthsBetween(start, end) + dayAdj
    }
  }
}
