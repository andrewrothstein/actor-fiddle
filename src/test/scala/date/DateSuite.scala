package date

import org.scalatest._
import date._

class DateSuite extends FunSuite {

  test ("days in year") {
    assert(Date.daysInYear(0) == 366)
    assert(Date.daysInYear(2000) == 366)
    assert(Date.daysInYear(1900) == 365)
    assert(Date.daysInYear(1600) == 366)
    assert(Date.daysInYear(2004) == 366)
  }
  
  test ("days in months") {
    assert(Date.daysInMonth(2000, Jan) == 31)
    assert(Date.daysInMonth(2000, Feb) == 29)
    assert(Date.daysInMonth(2013, Jun) == 30)
    assert(Date.daysInMonth(2013, Jul) == 31)
  }

  test ("julian dates") {
    assert(Date(0, Jan, 1).julian == 1)
    assert(Date(0, Jan, 2).julian == 2)
    assert(Date(0, Jan, 3).julian == 3)
    assert(Date(0, Feb, 1).julian == 32)
    assert(Date(1, Jan, 1).julian == 367)
  }
  
  test ("date diffs") {
    assert(Date.daysBetween(Date(2000, Jan, 1), Date(2000, Jan, 2)) == 1)
    assert(Date.daysBetween(Date(2000, Jan, 1), Date(2001, Jan, 1)) == 366)
    assert(Date.daysBetween(Date(2013, Jun, 1), Date(2013, Jul, 1)) == 30)
    assert(Date.daysBetween(Date(2000, Jan, 1), Date(2000, Feb, 1)) == 31)
  }
  
  test ("eom") {
    assert(Date(2013, Jan, 15).eom equals Date(2013, Jan, 31))
    assert(Date(2000, Feb, 15).eom equals Date(2000, Feb, 29))
    assert(Date(2013, Feb, 15).eom equals Date(2013, Feb, 28))
  }
}