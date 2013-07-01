import org.scalatest._

import date._

class AccrualSuite extends FunSuite {

  test ("basic accrual") {
    val rate = 4.3875 / 100.0
    val a = Accrual(DateCalc.D30360, Date(2013, 1), Date(2013, 2), rate)
    assert(a.alpha == 1.0 / 12.0)
    assert(a.effaccrual === rate / 12.0)
  }
  
}