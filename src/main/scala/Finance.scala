import math._

object Finance { 

  def amortizationFactor(i :Double, n :Double) = {
    i * (1.0 + 1.0 / (pow((1.0 + i), n) - 1.0))
  }

  def amortizationPayment(principal :Double, i :Double, n :Double) = { 
    principal * amortizationFactor(i, n)
  }
}
