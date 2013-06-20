import date.DateCalc
import date.Date

case class CashFlows(slices :List[RealizedFlow])

object CashFlows {

  def wal(cf: CashFlows, start: Date, dc: DateCalc) = {
    val ts = cf.slices.map((rf) => dc.alpha(start, rf.payDay.actualPayDay))
    val sumPrin = cf.slices.foldRight(0.0)((rf, s) => s + rf.principal)
    val printimest = ts.zip(cf.slices)
  }
  
  
  
}