package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test

class Day2Test {

    private val day = Day2()

    @Test
    fun testPartOne() {
        assertThat(day.partOne(), `is`(1227775554L))
    }

    @Test
    fun testPartTwo() {
        assertThat(day.partTwo(), `is`(4174379265L))
    }
}
