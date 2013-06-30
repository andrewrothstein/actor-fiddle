import date._
import date.DateCalc._
import math._
import org.scalatest._


class DateCalcSuite extends FunSuite { 

  test ("alpha") { 

	assert(ActAct.alpha(Date(2013,1,1), Date(2013,2,1)) == 31.0 / 365.0)
  }
}