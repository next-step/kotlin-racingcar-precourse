package Application

import kotlin.random.Random

// Model
class Car(val name: String, private val random: Random = Random.Default) {
    var position = 0
        private set

    fun move() {
        if (random.nextInt(10) >= 4) position++
    }

    // 테스트용 메서드
    internal fun setPositionForTesting(newPosition: Int) {
        position = newPosition
    }

    override fun toString() = "$name : ${"-".repeat(position)}"
}

class RaceGame(private val cars: List<Car>, private val attempts: Int) {
    private var currentAttempt = 0

    fun isFinished() = currentAttempt >= attempts

    fun nextTurn() {
        if (!isFinished()) {
            moveCars()
            currentAttempt++
        }
    }

    private fun moveCars() = cars.forEach { it.move() }

    fun getCars() = cars.toList()

    fun getWinners(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.map { it.name }
    }
}

// View
class RaceView {
    fun promptForCarNames() = println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)")
    fun promptForAttempts() = println("시도할 회수는 몇회인가요?")
    fun showError(message: String) = println(message)
    fun showRaceResult() = println("실행 결과")
    fun showCarStatus(car: Car) = println(car)
    fun showNewLine() = println()
    fun showWinners(winners: List<String>) = println("우승자: ${winners.joinToString(", ")}")
}

// Controller
class RaceController(private val view: RaceView) {
    fun startRace() {
        val cars = inputCars()
        val attempts = inputAttempts()
        val game = RaceGame(cars, attempts)

        view.showRaceResult()
        while (!game.isFinished()) {
            game.nextTurn()
            printCars(game.getCars())
            view.showNewLine()
        }

        view.showWinners(game.getWinners())
    }

    private fun inputCars(): List<Car> {
        while (true) {
            try {
                view.promptForCarNames()
                return readCarNames().map { createCar(it) }
            } catch (e: IllegalArgumentException) {
                view.showError(e.message ?: "알 수 없는 오류가 발생했습니다.")
            }
        }
    }

    private fun readCarNames(): List<String> {
        return readlnOrNull()?.split(",")?.map { it.trim() }
            ?: throw IllegalArgumentException("[ERROR] 입력이 없습니다.")
    }

    private fun createCar(name: String): Car {
        require(name.length <= 5) { "[ERROR] 자동차 이름은 5자 이하여야 합니다." }
        require(name.isNotEmpty()) { "[ERROR] 자동차 이름은 비어있을 수 없습니다." }
        return Car(name)
    }

    private fun inputAttempts(): Int {
        while (true) {
            try {
                view.promptForAttempts()
                return readAttempts()
            } catch (e: IllegalArgumentException) {
                view.showError(e.message ?: "알 수 없는 오류가 발생했습니다.")
            }
        }
    }

    private fun readAttempts(): Int {
        val input = readlnOrNull() ?: throw IllegalArgumentException("[ERROR] 입력이 없습니다.")
        val attempts = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 유효한 숫자를 입력해주세요.")
        require(attempts > 0) { "[ERROR] 시도 횟수는 1 이상이어야 합니다." }
        return attempts
    }

    private fun printCars(cars: List<Car>) = cars.forEach { view.showCarStatus(it) }
}

// Main function
fun main() {
    val view = RaceView()
    val controller = RaceController(view)
    controller.startRace()
}