package camp.nextstep.edu.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingCarTest {

    @Test
    fun initializeRacingCar() {
        val rightName = "abc"
        val wrongName = "anyone"

        val expectedResult = RacingCar("abc")
        val car = RacingCar(rightName)

        assert(car.name == expectedResult.name && car.moveSize == expectedResult.moveSize)
        assertThrows<IllegalArgumentException> { RacingCar(wrongName) }
    }

    @Test
    fun printFormatTest() {
        val car = RacingCar("abc", 3)

        val expectedResult = "abc : ---"

        assert(car.printFormat() == expectedResult)
    }

    @Test
    fun addMoveSizeTest() {
        val car = RacingCar("abc", 3)

        val expectedMoveSize = 3..4
        car.addMoveSize()

        assert(car.moveSize in expectedMoveSize)
    }

    @Test
    fun isWinnerTest() {
        val winner = RacingCar("abc", 3)
        val justCar = RacingCar("qwe", 1)

        val maxMoveSize = 3

        assert(winner.isWinner(maxMoveSize))
        assert(!justCar.isWinner(maxMoveSize))
    }
}