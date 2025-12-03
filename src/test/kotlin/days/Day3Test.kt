package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test

class Day3Test {

    private val day = Day3()

    @Test
    fun testPartOne() {
        assertThat(day.partOne(), `is`(357L))
    }

    @Test
    fun testPartTwo() {
        assertThat(day.partTwo(), `is`(3121910778619))
    }

    @Test
    fun testGetMaximumJoltage() {
        assertThat(day.getMaximumJoltage("987654321111111", 2), `is`(98))
        assertThat(day.getMaximumJoltage("811111111111119", 2), `is`(89))
        assertThat(day.getMaximumJoltage("234234234234278", 2), `is`(78))
        assertThat(day.getMaximumJoltage("818181911112111", 2), `is`(92))

        assertThat(day.getMaximumJoltage("987654321111111", 12), `is`(987654321111))
        assertThat(day.getMaximumJoltage("811111111111119", 12), `is`(811111111119))
        assertThat(day.getMaximumJoltage("234234234234278", 12), `is`(434234234278))
        assertThat(day.getMaximumJoltage("818181911112111", 12), `is`(888911112111))
    }
}
