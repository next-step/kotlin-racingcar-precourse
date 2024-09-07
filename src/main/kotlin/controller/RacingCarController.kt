package controller

import model.RacingCarModel
import view.RacingCarView
import kotlin.random.Random

class RacingCarController(
    private val models: MutableList<RacingCarModel>,
    private val view: RacingCarView,
) {
    private fun checkCarName(name: String): List<String>? {
        val carName = name.split(',').map { it.trim() }

        if (carName.any { it.isBlank() || it.length > 5}) {
            return null
        }
        return carName
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
        val racingCount = count.toIntOrNull()?.takeIf { it > 0 }
        return racingCount
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

    private fun createRacingCar(cars: List<String>) {
        view.printEmptyLine()
        view.printGameResult()

        models.addAll(cars.map { RacingCarModel(it,0) })
    }

    private fun updateRacingCar() {
        models.forEach { model ->
            val randomValue = Random.nextInt(10)
            if (randomValue >= 4) {
                model.race += 1
            }

            view.printRacingCar(model.car, model.race)
        }
        view.printEmptyLine()
    }

    fun playRacingCarGame() {
        val cars = getCarName()
        val counts = getRacingCount()

        createRacingCar(cars)
        repeat(counts) {
            updateRacingCar()
        }
    }
}