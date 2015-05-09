package ii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate) = when{
        this.year != other.year -> this.year - other.year
        this.month != other.month -> this.month - other.month
        else -> this.dayOfMonth - other.dayOfMonth
    }
}

enum class TimeInterval {
    DAY
    WEEK
    YEAR
}

class DateRange(public override val start: MyDate, public override val end: MyDate) : Iterable<MyDate>, Range<MyDate>{
    override fun contains(item: MyDate): Boolean = start <= item && item <= end

    override fun iterator() = object : Iterator<MyDate> {

        var current = start

        override fun next(): MyDate {
            val temp = current
            current = current.nextDay()
            return temp
        }

        override fun hasNext(): Boolean = current <= end

    }

}

fun MyDate.rangeTo(other: MyDate) = DateRange(this,other)

fun MyDate.plus(time: TimeInterval) = addTimeIntervals(time,1)
fun MyDate.plus(time: RepeatedTimeInterval) = addTimeIntervals(time.ti,time.n)

fun TimeInterval.times(n: Int) = RepeatedTimeInterval(this,n)

class RepeatedTimeInterval(val ti: TimeInterval, val n: Int)