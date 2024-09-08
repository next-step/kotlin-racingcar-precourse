package view

import model.Car

class WinnerView : View {
    companion object {
        const val WINNER_ANNOUNCE_PREFIX = "최종 우승자 :"
    }

    fun printWinners(cars: List<Car>) {
        println("$WINNER_ANNOUNCE_PREFIX ${cars.joinToString { car -> car.name }}")
    }
}