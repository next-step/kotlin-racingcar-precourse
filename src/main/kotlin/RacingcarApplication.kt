import controller.RacingCarController
import view.RacingCarView

fun main() {
    val view = RacingCarView()
    val controller = RacingCarController(view)

    controller.playRacingCarGame()
}