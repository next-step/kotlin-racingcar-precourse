import controller.RacingCarController
import view.RacingCarView

fun main() {
    val view = RacingCarView()
    val controller = RacingCarController(mutableListOf(), view)

    controller.playRacingCarGame()
}