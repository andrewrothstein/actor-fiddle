package cre

case class Lease(remTerm :Int, rentPerSqFt :Double)

object Lease {

  lazy val Vacant = Lease(0,0)
  
  def next(l :Lease, renewFunc :Function[Lease, Lease]) = {
    if (l.remTerm == 0) renewFunc(l) else Lease(l.remTerm - 1, l.rentPerSqFt)
  }
}