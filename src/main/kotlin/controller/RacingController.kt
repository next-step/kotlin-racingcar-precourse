package controller

import model.RacingCar
import model.RacingCarRepository
import view.RacingCarView
import kotlin.random.Random

class RacingController(
    private val racingCarView: RacingCarView,
    private val racingCarRepository: RacingCarRepository,
) {

    fun playRacing() {
        if (racingCarRepository.getRacingCount() == null) {
            throw IllegalStateException("the racing count is not set")
        }

        for (i in 0..racingCarRepository.getRacingCount()!!) {
            for (car in racingCarRepository.getAllRacingCar()) {
                if (checkWhetherMoveOrNot()) {
                    car.moveCnt += 1
                }
            }
            racingResultStatus()
        }
    }

    private fun checkWhetherMoveOrNot(): Boolean {
        val randomNumber = Random.nextInt(0, 9)
        return randomNumber >= 4
    }

    private fun racingResultStatus() = racingCarView.printRacingStatus(racingCarRepository.getAllRacingCar())

    fun finalWinners() {
        val finalWinners = racingCarRepository.getFinalWinner()
        racingCarView.printFinalWinners(finalWinners)
    }

    fun initRacingCar() {
        val racingCarList = racingCarView.getRacingCarInput()
        racingCarRepository.addRacingCar(racingCarList)

        val gameCount = racingCarView.getRacingCountInput()
        racingCarRepository.setRacingCount(gameCount)
    }
}