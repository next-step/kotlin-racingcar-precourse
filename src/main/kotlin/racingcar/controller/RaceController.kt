package racingcar.controller

import racingcar.model.Car
import racingcar.view.RaceView
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.random.Random

class RaceController() {
    private val raceView = RaceView()

    fun play() {
        val carList = getCarNameList().map { Car(it) }
        val playCount = getPlayCount()

        repeat(playCount) {
            moveAllCar(carList)
            raceView.printCarStatusList(carList)
        }

        raceView.printWinner(getWinnerList(carList))
    }

    private fun getCarNameList(): List<String> = with(BufferedReader(InputStreamReader(System.`in`))) {
        raceView.printCarNameGuide()

        val carNameList = readLine().split(",").map { it.trim() }
        if (carNameList.any { it.isEmpty() || it.length > 5 }) {
            throw IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.")
        }

        return carNameList
    }

    private fun getPlayCount(): Int = with(BufferedReader(InputStreamReader(System.`in`))) {
        raceView.printPlayCountGuide()
        return readLine().trim().toInt()
    }

    private fun canMove(): Boolean {
        return Random.nextInt(0, 10) >= 4
    }

    private fun moveAllCar(carList: List<Car>) {
        carList.forEach { car: Car ->
            if (canMove()) {
                car.position++
            }
        }
    }

    private fun getWinnerList(carList: List<Car>): List<Car> {
        val maxPosition = carList.maxOf { it.position }
        return carList.filter { it.position == maxPosition }
    }
}