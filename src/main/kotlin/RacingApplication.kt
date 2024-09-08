import controller.RacingController
import model.Car
import view.RegisterCarView
import view.View

val racingCarController = RacingController()
fun main() {
    // 차량 input 받음
    val registerCarView = RegisterCarView()
    registerCarView.printCarNameInputMessage()
    val carNames = registerCarView.scanCarNames()

    // controller 차량 등록 호출
    val cars = registerCars(carNames, registerCarView)

    // 몇회 전진 입력 받음
    // controller 전진 호출
    // 차량 전진 출력
    // controller 우승자 계산 호출
    // 우승자 출력
}

private fun registerCars(carNames: String, view: View): List<Car> {
    while (true) {
        try {
            return racingCarController.registerCars(carNames)
        } catch (exception: IllegalArgumentException) {
            view.printErrorMessage(exception)
        }
    }
}