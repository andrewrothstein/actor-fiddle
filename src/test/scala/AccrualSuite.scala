import org.scalatest._

import date._

class AccrualSuite extends FunSuite {

  test ("basic accrual") {
    val rate = 4.3875
    val a = Accrual(DateCalc.ActAct, Date(2013, 1), Date(2013, 2), rate / 100.0)
    assert(a.alpha == 31. / 365.0)
    assert(a.effaccrual === rate / 100.0 * 31.0 / 365.0)
  }
  
}