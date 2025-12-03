package days

class Day3 : Day(3) {

    override fun partOne(): Any {
        return inputList.sumOf { getMaximumJoltage(it, 2) }
    }

    override fun partTwo(): Any {
        return inputList.sumOf { getMaximumJoltage(it, 12) }
    }

    fun getMaximumJoltage(bank: String, batteryNumber: Int): Long {
        var number = ""
        var lastIndex = 0
        for (digitsRemaining in (batteryNumber downTo 1)) {
            val maxIndex = bank.length - digitsRemaining
            val highest = bank.withIndex()
                .dropWhile { it.index < lastIndex }
                .takeWhile { it.index <= maxIndex }
                .maxBy { it.value.digitToInt() }
            number += highest.value
            lastIndex = highest.index + 1
        }
        return number.toLong()
    }
}
