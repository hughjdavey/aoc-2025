package days

class Day2 : Day(2) {

    private val rangeLists = inputString.split(",")
        .map { it.trim().split("-").map(String::toLong) }
        .flatMap { (min, max) -> (min..max).toList() }

    override fun partOne(): Any {
        return rangeLists.fold(listOf<Long>()) { invalidIds, id ->
            if (isInvalid(id, true)) invalidIds + id else invalidIds
        }.sum()
    }

    override fun partTwo(): Any {
        return rangeLists.fold(listOf<Long>()) { invalidIds, id ->
            if (isInvalid(id)) invalidIds + id else invalidIds
        }.sum()
    }

    private fun isInvalid(id: Long, onlyRepeatTwice: Boolean = false): Boolean {
        val str = id.toString(10)
        if (onlyRepeatTwice) {
            val (head, tail) = stringHalves(str)
            return head == tail
        }
        (1..str.length / 2).forEach { i ->
            val (head, tail) = str.substring(0, i) to str.substring(i).chunked(i)
            if (tail.all { it == head }) {
                return true
            }
        }
        return false
    }

    private fun stringHalves(str: String): Pair<String, String> {
        val halfwayPoint = str.length / 2
        return str.substring(0, halfwayPoint) to str.substring(halfwayPoint)
    }
}
