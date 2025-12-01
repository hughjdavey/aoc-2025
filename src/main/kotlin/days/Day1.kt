package days

class Day1 : Day(1) {

    private val rotations = inputList.map { it[0] to it.substring(1).toInt() }
    private val safeAfterRotations = Safe().apply { rotations.forEach { rotate(it.first, it.second) } }

    override fun partOne(): Any {
        return safeAfterRotations.rotationZeroes
    }

    override fun partTwo(): Any {
        return safeAfterRotations.turnZeroes
    }

    class Safe(private var dial: Int = 50, private val max: Int = 99, private val min: Int = 0) {

        var rotationZeroes = 0
        var turnZeroes = 0

        fun rotate(direction: Char, amount: Int) {
            (0 until amount).forEach { _ -> turn(direction) }
            if (dial == 0) rotationZeroes++
        }

        fun turn(direction: Char) {
            when (direction) {
                'R' -> if (dial == max) dial = min else dial += 1
                'L' -> if (dial == min) dial = max else dial -= 1
                else -> throw IllegalArgumentException("Invalid direction: $direction")
            }
            if (dial == 0) turnZeroes++
        }
    }
}
