package camp.nextstep.edu.view

import camp.nextstep.edu.controller.GameController
import camp.nextstep.edu.model.RacingCar

class ConsoleView(
    private val gameController: GameController
) {
    fun inputRacingCarNameGuide() = println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")

    fun inputRacingCar(): List<RacingCar> {
        val input = readln()
        return gameController.createRacingCars(input)
    }

    fun inputMoveTimeGuide() = println("시도할 회수는 몇회인가요?")

    fun inputMoveTime(): Int? {
        val input: Int
        try {
            input = readln().toInt()
        } catch (e: NumberFormatException) {
            println("[ERROR] input need to integer type")
            return null
        }

        try {
            checkNumberOverZero(input)
        } catch (e: IllegalArgumentException) {
            println("[ERROR] input must be over 0")
            return null
        }
        return input
    }

    private fun checkNumberOverZero(number: Int) {
        if (number <= 0) {
            throw IllegalArgumentException()
        }
    }
}