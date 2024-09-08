package controller

import model.Car
import view.RacingView
import view.WinnerView

class RacingController {

    companion object {
        const val CAR_NAME_SEPARATOR = ","
    }

    fun registerCars(carNameInput: String): List<Car> {
        val carNames = carNameInput.split(CAR_NAME_SEPARATOR)
            .map { it.trim() }

        return carNames.map { Car(it) }
    }

    fun racing(): RacingView {
        TODO()
    }

    fun calculateWinner(): WinnerView {
        TODO()
    }
}