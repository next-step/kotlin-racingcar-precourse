package view

import model.Car

class RacingView : View {
    companion object {
        private const val MESSAGE_RACING_RESULT_PREFIX = "실행 결과"
    }

    fun printRacingDistance(cars: List<Car>) {
        println(MESSAGE_RACING_RESULT_PREFIX)
        cars.forEach { car ->
            println("${car.name} : ${car.distance}")
        }
        println()
    }
}