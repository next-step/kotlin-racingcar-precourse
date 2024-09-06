import domain.Car
import view.InputView

fun main() {
    val inputView = InputView()
    val inputCarNames = inputView.inputCarNames()
    val cars = inputCarNames
        .map { Car(carName = it) }
        .toList()

    val inputNumberOfAttempts = inputView.inputNumberOfAttempts()
}
