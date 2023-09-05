class Time(private var h: Int, private var m: Int) {
  require(0 <= h && h < 24)
  require(0 <= m && m < 60)

  def hour: Int = h

  def hour_=(newHour: Int) {
    require(0 <= newHour && newHour < 24) // require throws IllegalArgumentException
    h = newHour
  }

  def minute: Int = m

  def minute_=(newMinute: Int) {
    require(0 <= newMinute && newMinute < 60)
    m = newMinute
  }

  def before(other: Time): Boolean =
    h < other.h || h == other.h && m < other.m
}
