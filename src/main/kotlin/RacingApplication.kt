import controller.RacingController
import model.Car
import view.RacingView
import view.RoundView
import view.RegisterCarView

val racingCarController = RacingController()
fun main() {
    val cars = registerCars()

    val rounds = scanRounds()

    racing(cars, rounds)
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

private fun scanRounds(): Int {
    val roundView = RoundView()
    while (true) {
        try {
            roundView.printRoundInputMessage()
            return roundView.scanRound()
        } catch (exception: NumberFormatException) {
            roundView.printErrorMessage(exception)
        }
    }
}

private fun racing(cars: List<Car>, rounds: Int) {
    val racingView = RacingView()
    for (round in 1..rounds) {
        racingCarController.racing(cars)
        racingView.printRacingDistance(cars)
    }
}