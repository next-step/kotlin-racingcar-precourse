package camp.nextstep.edu.controller

import camp.nextstep.edu.model.RacingCar

class GameController() {
    fun createRacingCars(carNameString: String): List<RacingCar> {
        val carNames = carNameString.split(",")
        val cars: MutableList<RacingCar> = arrayListOf()
        carNames.forEach {
            try {
                cars.add(RacingCar(it))
            } catch (e: IllegalArgumentException) {
                println("[ERROR] name length must not be longer than 5")
                return emptyList()
            }
        }
        return cars.toList()
    }

    fun moveCars(cars: List<RacingCar>): List<RacingCar> {
        for (car in cars) {
            car.addMoveSize()
        }
        return cars
    }
}