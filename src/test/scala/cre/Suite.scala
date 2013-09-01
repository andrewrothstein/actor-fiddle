package cre

case class Suite(sqFt :Double, lease :Lease) {
  def rent = sqFt * lease.rentPerSqFt
}