package view

import model.Car

class RacingView : View {
    companion object {
        private const val MESSAGE_RACING_RESULT_PREFIX = "실행 결과"
    }

    fun printRacingResultPrefix() {
        println(MESSAGE_RACING_RESULT_PREFIX)
    }

    fun printRacingDistance(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${car.distance}")
        }
        println()
    }
}