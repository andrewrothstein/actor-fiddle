import org.scalatest._
import scala.collection.immutable.List

class CashflowSuite extends FunSuite { 

  def schedBulletAccrual = Accrual()
  def schedBulletCf = ScheduledFlow.ioFlow(accrual, payDay, beginBal, remainingTerm, rate)
  
  test ("WAL)") { 
	  
  }
}
