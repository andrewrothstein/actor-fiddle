import Finance._
import math._
import org.scalatest._

class FinanceSuite extends FunSuite { 

  test ("simple amortization") { 

    val balance = 1000000.0
    val rate = 4.5 / 100.0
    val term = 360.0

    assert(round(amortizationPayment(balance, rate / 12.0, term)) == 5067.0)
    
  }
}
