package camp.nextstep.edu

import camp.nextstep.edu.controller.GameController
import camp.nextstep.edu.service.GameService
import camp.nextstep.edu.view.ConsoleView

fun main(args: Array<String>) {
    val consoleView = ConsoleView(GameController(GameService()))
    consoleView.inputRacingCarNameGuide()
    var racingCars = consoleView.inputRacingCar()
    while(racingCars.isEmpty()) {
        consoleView.inputRacingCarNameGuide()
        racingCars = consoleView.inputRacingCar()
    }

    consoleView.inputMoveTimeGuide()
    var moveTime = consoleView.inputMoveTime()
    while (moveTime == null) {
        consoleView.inputMoveTimeGuide()
        moveTime = consoleView.inputMoveTime()
    }
}
