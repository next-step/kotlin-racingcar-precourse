package camp.nextstep.edu.controller

import camp.nextstep.edu.model.RacingCar
import camp.nextstep.edu.service.GameService

class GameController(
    private val gameService: GameService
) {
    fun createRacingCars(carNameString: String): List<RacingCar> {
        val carNames = carNameString.split(",")
        return gameService.addCars(carNames)
    }
}