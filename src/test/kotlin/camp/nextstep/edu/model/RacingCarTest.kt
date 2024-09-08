package camp.nextstep.edu.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingCarTest {

    @Test
    fun initializeRacingCar() {
        // given
        val rightName = "abc"
        val wrongName = "anyone"

        // when
        val expectedResult = RacingCar("abc")
        val rightResult = RacingCar(rightName)

        // then
        assert(rightResult != expectedResult)
        assertThrows<IllegalArgumentException> { RacingCar(wrongName) }
    }
}