package date

import date._
import date.DateCalc._
import math._
import org.scalatest._


class DateCalcSuite extends FunSuite { 

  test ("ActAct") { 
	assert(ActAct.alpha(Date(2013,Jan,1), Date(2013,Feb,1)) == 31.0 / 365.0)
  }

  test ("D30360") { 
	assert(D30360.alpha(Date(2013,Jan,1), Date(2013,Feb,1)) == 1.0 / 12.0)
	assert(D30360.alpha(Date(2013,Jan,31), Date(2013,Feb,28)) == 1.0 / 12.0)
	assert(D30360.alpha(Date(2013,Jan,15), Date(2013,Feb,15)) == 1.0 / 12.0)
  }
}