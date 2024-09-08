package controller

import CarValidator
import model.Car
import randomInt

class RacingController {

    companion object {
        const val CAR_NAME_SEPARATOR = ","
    }

    fun registerCars(carNameInput: String): List<Car> {
        val carNames = carNameInput.split(CAR_NAME_SEPARATOR)
            .map { it.trim() }
        CarValidator.validateCarNames(carNames)

        return carNames.map { Car(it) }
    }

    fun racing(cars: List<Car>): List<Car> {
        cars.forEach { car ->
            car.move(randomInt(0, 9))
        }
        return cars
    }

    fun calculateWinner() {
        TODO()
    }
}