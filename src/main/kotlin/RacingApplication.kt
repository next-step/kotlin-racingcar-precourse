import controller.RacingController
import model.Car
import view.RacingView
import view.RegisterCarView

val racingCarController = RacingController()
fun main() {
    val cars = registerCars()

    // 몇회 전진 입력 받음
    val round = scanRound()

    // controller 전진 호출
    // 차량 전진 출력
    // controller 우승자 계산 호출
    // 우승자 출력
}

private fun registerCars(): List<Car> {
    val registerCarView = RegisterCarView()
    while (true) {
        try {
            // 차량 input 받음
            registerCarView.printCarNameInputMessage()
            val carNames = registerCarView.scanCarNames()

            // controller 차량 등록 호출
            return racingCarController.registerCars(carNames)
        } catch (exception: IllegalArgumentException) {
            registerCarView.printErrorMessage(exception)
        }
    }
}

private fun scanRound(): Int {
    val racingView = RacingView()
    while (true) {
        try {
            racingView.printRoundInputMessage()
            return racingView.scanRound()
        } catch (exception: NumberFormatException) {
            racingView.printErrorMessage(exception)
        }
    }
}