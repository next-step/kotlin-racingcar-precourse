package camp.nextstep.edu

import camp.nextstep.edu.controller.GameController
import camp.nextstep.edu.view.ConsoleView

fun main(args: Array<String>) {
    val consoleView = ConsoleView(GameController())
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

    consoleView.resultTitle()
    for (i in 1..moveTime) {
        consoleView.printResult(racingCars)
    }
}
