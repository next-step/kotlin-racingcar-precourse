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
        println()
        return input
    }

    fun resultTitle() = println("실행 결과")
    fun printMoveResult(cars: List<RacingCar>): List<RacingCar> {
        val newCars = gameController.moveCars(cars)
        newCars.forEach {
            println(it.printFormat())
        }
        println()
        return newCars
    }

    fun printWinner(cars: List<RacingCar>) {
        var printString = "최종 우승자 : "
        val winners = gameController.getWinners(cars)
        winners.forEach { printString = printString.plus("${it.name}, ") }
        printString = printString.removeSuffix(", ")
        println(printString)
    }

    private fun checkNumberOverZero(number: Int) {
        if (number <= 0) {
            throw IllegalArgumentException()
        }
    }
}