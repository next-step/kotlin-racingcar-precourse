package model

import controller.RacingController
import kotlin.random.Random

class RacingCarRepository () {
    private var racingCarList: MutableList<RacingCar>? = null
    private var racingGameCount: Int? = null

    fun addRacingCar(racingCars: MutableList<RacingCar>) {
        racingCarList = racingCars
    }

    fun getAllRacingCar(): MutableList<RacingCar> = racingCarList!!

    fun setRacingCount(count: Int) { racingGameCount = count }
    fun getRacingCount() = racingGameCount

    fun getFinalWinner() = checkFinalWinner()

    private fun checkFinalWinner(): String {
        var maxMoveCnt = 0
        var finalWinners = ""
        for (car in racingCarList!!) {
            if (car.moveCnt > maxMoveCnt) {
                maxMoveCnt = car.moveCnt
                finalWinners = car.name
            } else if (car.moveCnt == maxMoveCnt) {
                finalWinners = finalWinners + ", " + car.name
            }
        }
        return finalWinners
    }
}