package camp.nextstep.edu.view

import camp.nextstep.edu.controller.GameController
import camp.nextstep.edu.model.RacingCar

class ConsoleView(
    private val gameController: GameController
) {
    fun inputRacingCarNameGuide() = println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    fun inputRacingCar(): List<RacingCar> {
        val input = readln()
        return gameController.createRacingCars(input)
    }
}