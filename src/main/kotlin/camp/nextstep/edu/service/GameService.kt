package camp.nextstep.edu.service

import camp.nextstep.edu.model.RacingCar

class GameService {
    fun addCars(carNames: List<String>): List<RacingCar> {
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
}