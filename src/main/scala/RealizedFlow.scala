case class RealizedFlow(
  schedFlow: ScheduledFlow,
  principal: Double,
  interest: Double) {
  def payDay = schedFlow.payDay
  lazy val endBal = schedFlow.beginBal - principal

  lazy val interestShortfall = schedFlow.interest - interest
  lazy val principalShortfall = schedFlow.principal - principal
}

object RealizedFlow {

  def create(schedFlow: ScheduledFlow, smm: Double, mdr: Double, sev: Double, dq:Double = 0.0) = {
    val prepaidPrincipal = schedFlow.endBal * smm
    val defaultedPrincipal = schedFlow.endBal * mdr
    val lostPrincipal = defaultedPrincipal * sev
    val recoveredPrincipal = defaultedPrincipal - lostPrincipal

    RealizedFlow(
      schedFlow,
      schedFlow.principal + prepaidPrincipal + recoveredPrincipal,
      schedFlow.interest * (1.0 - dq))
  }

}