package controller

import model.RacingCarModel
import service.RacingCarService
import view.RacingCarView

class RacingCarController(
    private val models: MutableList<RacingCarModel>,
    private val view: RacingCarView,
    private val service: RacingCarService = RacingCarService(models, view),
) {
    private fun checkCarName(name: String): List<String>? {
        val names = name.split(',').map { it.trim() }

        val carNames = names.takeIf { carName ->
            carName.all { it.isNotBlank() && it.length <= 5 }
        }
        return carNames
    }

    private fun getCarName(): List<String> {
        view.printCarName()

        while (true) {
            try {
                val inputName = view.enterInputValue()?.takeIf { it.isNotBlank() }
                    ?: throw IllegalArgumentException("경주할 자동차 이름이 입력되지 않았습니다.")

                val carName = checkCarName(inputName)
                    ?: throw IllegalArgumentException("경주할 자동차 이름은 1자 이상 5자 이하만 가능합니다.")
                return carName
            } catch (e: IllegalArgumentException) {
                view.printErrorMessage(e.message)
            }
        }
    }

    private fun checkRacingCount(count: String): Int? {
        val racingCounts = count.toInt().takeIf { it > 0 }
        return racingCounts
    }

    private fun getRacingCount(): Int {
        view.printRacingCount()

        while (true) {
            try {
                val inputCount = view.enterInputValue()?.takeIf { it.isNotBlank() }
                    ?: throw IllegalArgumentException("시도할 횟수가 입력되지 않았습니다.")

                val racingCount = checkRacingCount(inputCount)
                    ?: throw IllegalArgumentException("시도할 횟수는 1 이상의 정수만 가능합니다.")
                return racingCount
            } catch (e: IllegalArgumentException) {
                view.printErrorMessage(e.message)
            }
        }
    }

    fun playRacingCarGame() {
        val cars = getCarName()
        val counts = getRacingCount()

        service.createRacingCar(cars)
        repeat(counts) {
            service.updateRacingCar()
        }

        service.findRacingCarWinner()
    }
}