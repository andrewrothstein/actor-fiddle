import date.Date

case class PayDate(nominalPayDay :Date, delay :Int = 0) {
	val actualPayDay = nominalPayDay.addDays(delay)
}