package controller

import view.RacingCarView

class RacingCarController(
    private val view: RacingCarView
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
                view.printErrorMessage(e.message.toString())
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

    fun playRacingCarGame() {
        val cars = getCarName()
        val counts = getRacingCount()
    }
}