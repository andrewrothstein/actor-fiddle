case class RealizedFlow(
    schedFlow: ScheduledFlow, 
    principal: Double, 
    interest: Double)
{
  val payDay = schedFlow.payDay
  val endBal = schedFlow.beginBal - principal
}