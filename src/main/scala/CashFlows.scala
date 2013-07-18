import date.DateCalc
import date.Date


case class CashFlows(slices :List[RealizedFlow]) {
  private def sumFolder(sum :Double, s :Double) = sum + s
  private def sum(v :List[Double]) = (0.0 /: v)(sumFolder)

  lazy val principals = slices.map((s => s.principal))
  lazy val sumPrincipal = sum(principals)
  lazy val interests = slices.map((s => s.interest))
  lazy val sumInterest = sum(interests)

  def times(start :Date, dc :DateCalc) = slices map (s => dc.alpha(start, s.payDay.actualPayDay))
  
  def wal(start: Date, dc: DateCalc) = {
    val timeWeightedPrincipal = (times(start, dc) zip principals) map (t => t._1 * t._2)
    val sumTtimeP = sum(timeWeightedPrincipal)
    sumTtimeP / sumPrincipal
  }
}

object CashFlows {
}