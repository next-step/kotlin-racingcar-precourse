import controller.RacingCarController
import model.RacingCarModel
import service.RacingCarService
import view.RacingCarView

fun main() {
    val models = mutableListOf<RacingCarModel>()
    val view = RacingCarView()
    val service = RacingCarService(models, view)
    val controller = RacingCarController(models, view, service)

    controller.playRacingCarGame()
}