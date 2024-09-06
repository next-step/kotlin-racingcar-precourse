import domain.Car
import domain.Cars
import view.InputView
import view.OutputView
import java.util.*

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val inputCarNames = inputView.inputCarNames()
    val cars = Cars(
        inputCarNames.map { Car(carName = it) }.toList()
    )

    outputView.printResultHeader()

    val inputNumberOfAttempts = inputView.inputNumberOfAttempts()
    repeat(inputNumberOfAttempts) {
        cars.move(Random())
        outputView.printCurrent(cars)
    }

    val winners = cars.winners()
    outputView.printResultWinner(winners)
}
