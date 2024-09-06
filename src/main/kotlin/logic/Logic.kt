package logic

import car.Car

class Logic {
    fun findWinner(inputCars: List<Car>): List<String> {
        val maxValue = inputCars.maxOfOrNull {
            it.position
        }

        return inputCars
            .filter { it.position == maxValue }
            .map { it.participantName }
            .toList()
    }
}