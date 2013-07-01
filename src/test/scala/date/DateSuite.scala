package date

import org.scalatest._
import date._
import sun.security.tools.AddEntryDoneButtonListener

class DateSuite extends FunSuite {

  test ("days in year") {
    assert(Date.daysInYear(0) === 366)
    assert(Date.daysInYear(2000) === 366)
    assert(Date.daysInYear(1900) === 365)
    assert(Date.daysInYear(1600) === 366)
    assert(Date.daysInYear(2004) === 366)
  }

  test ("days left in year") {
    assert(Date(2013, Dec, 31).daysLeftInYear === 0)
    assert(Date(2013, Dec, 30).daysLeftInYear === 1)
    assert(Date(2013, Dec, 1).daysLeftInYear === 30)
    assert(Date(2013, Nov, 30).daysLeftInYear === 31)
    assert(Date(2013, Jan, 1).daysLeftInYear === 364)
  }
  
  test ("day in year") {
	  assert(Date(2013, Jan, 1).dayInYear === 1)
	  assert(Date(2013, Dec, 31).dayInYear === 365)
  }

  test ("days in months") {
    assert(Date.daysInMonth(2000, Jan) === 31)
    assert(Date.daysInMonth(2000, Feb) === 29)
    assert(Date.daysInMonth(2013, Jun) === 30)
    assert(Date.daysInMonth(2013, Jul) === 31)
  }
  
  test ("days left in month") {
    assert(Date(2013, Dec, 31).daysLeftInMonth === 0)
    assert(Date(2013, Dec, 30).daysLeftInMonth === 1)
    assert(Date(2013, Dec, 1).daysLeftInMonth === 30)
    assert(Date(2013, Nov, 30).daysLeftInMonth === 0)
    assert(Date(2013, Nov, 15).daysLeftInMonth === 15)
  }
  

  test ("julian dates") {
    assert(Date(0, Jan, 1).julian === 1)
    assert(Date(0, Jan, 2).julian === 2)
    assert(Date(0, Jan, 3).julian === 3)
    assert(Date(0, Feb, 1).julian === 32)
    assert(Date(1, Jan, 1).julian === 367)
  }
  
  test ("date diffs") {
    assert(Date.daysBetween(Date(2000, Jan, 1), Date(2000, Jan, 2)) === 1)
    assert(Date.daysBetween(Date(2000, Jan, 1), Date(2001, Jan, 1)) === 366)
    assert(Date.daysBetween(Date(2013, Jun, 1), Date(2013, Jul, 1)) === 30)
    assert(Date.daysBetween(Date(2000, Jan, 1), Date(2000, Feb, 1)) === 31)
  }
  
  test ("eom") {
    assert(Date(2013, Jan, 15).eom === Date(2013, Jan, 31))
    assert(Date(2000, Feb, 15).eom === Date(2000, Feb, 29))
    assert(Date(2013, Feb, 15).eom === Date(2013, Feb, 28))
  }
  
  test ("asYYYYMMDD") {
    assert(Date(1978, Nov, 14).asYYYYMMDD === 19781114)
    assert(Date(2013, Jan, 15).asYYYYMMDD === 20130115)
    assert(Date(2013, Feb, 28).asYYYYMMDD === 20130228)
  }
  
  test ("months diff") {
    assert(Date.monthsBetween(Date(1978, Nov), Date(1978, Nov)) === 0)
    assert(Date.monthsBetween(Date(1978, Nov), Date(1978, Dec)) === 1)
    assert(Date.monthsBetween(Date(1978, Dec), Date(1978, Nov)) === -1)
    assert(Date.monthsBetween(Date(1978, Nov), Date(1979, Oct)) === 11)
    assert(Date.monthsBetween(Date(1979, Oct), Date(1978, Nov)) === -11)
    assert(Date.monthsBetween(Date(1978, Oct), Date(1979, Oct)) === 12)
    assert(Date.monthsBetween(Date(1979, Oct), Date(1978, Oct)) === -12)
  }
  
  test ("add days") {
    assert(Date(2013, Dec, 31).addDays(1) === Date(2014, Jan, 1))
    assert(Date(2013, Dec, 1).addDays(31) === Date(2014, Jan, 1))
    assert(Date(2013, Jan, 1).addDays(365) === Date(2014, Jan, 1))
    assert(Date(2013, Nov, 30).addDays(1) === Date(2013, Dec, 1))
    assert(Date(2013, Nov, 15).addDays(16) === Date(2013, Dec, 1))
    assert(Date(2013, Nov, 15).addDays(15) === Date(2013, Nov, 30))
  }
  
  test ("subtract days") {
    assert(Date(2014, Jan, 1).subtractDays(1) === Date(2013, Dec, 31))
    assert(Date(2014, Jan, 1).subtractDays(31) === Date(2013, Dec, 1))
    assert(Date(2014, Jan, 1).subtractDays(365) === Date(2013, Jan, 1))
    assert(Date(2014, Nov, 15).subtractDays(15) === Date(2014, Oct, 31))
    assert(Date(2014, Nov, 15).subtractDays(14) === Date(2014, Nov, 1))
  }
}