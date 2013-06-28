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
    assert(Date.daysInMonth(2000, 1) == 31)
    assert(Date.daysInMonth(2000, 2) == 29)
    assert(Date.daysInMonth(2013, 6) == 30)
    assert(Date.daysInMonth(2013, 7) == 31)
  }

  test ("julian dates") {
    assert(Date(0, 1, 1).julian == 1)
    assert(Date(0, 1, 2).julian == 2)
    assert(Date(0, 1, 3).julian == 3)
    assert(Date(0, 2, 1).julian == 32)
    assert(Date(1, 1, 1).julian == 367)
  }
  
  test ("date diffs") {
    assert(Date.daysBetween(Date(2000, 1, 1), Date(2000, 1, 2)) == 1)
    assert(Date.daysBetween(Date(2000, 1, 1), Date(2001, 1, 1)) == 366)
    assert(Date.daysBetween(Date(2013, 6, 1), Date(2013, 7, 1)) == 30)
    assert(Date.daysBetween(Date(2000, 1, 1), Date(2000, 2, 1)) == 31)
  }
}