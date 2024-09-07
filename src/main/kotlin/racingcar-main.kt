import controller.RacingController
import model.RacingCarRepository
import view.RacingCarView

fun main() {

    val racingCarView = RacingCarView()
    val racingCarRepository = RacingCarRepository()
    val racingCarController = RacingController(racingCarView, racingCarRepository)

    racingCarController.initRacingCar()
    racingCarController.playRacing()
    racingCarController.finalWinners()
}
