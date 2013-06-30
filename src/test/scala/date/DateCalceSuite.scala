package date

import date._
import date.DateCalc._
import math._
import org.scalatest._


class DateCalcSuite extends FunSuite { 

  test ("alpha") { 

	assert(ActAct.alpha(Date(2013,Jan,1), Date(2013,Feb,1)) == 31.0 / 365.0)
  }
}