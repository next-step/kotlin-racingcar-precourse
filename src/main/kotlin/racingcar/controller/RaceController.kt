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

        moveAllCar(carList)
        raceView.printCarStatusList(carList)
    }

    private fun getCarNameList(): List<String> = with(BufferedReader(InputStreamReader(System.`in`))) {
        raceView.printCarNameGuide()

        val carNameList = readLine().split(",").map { it.trim() }
        if (carNameList.any { it.isEmpty() || it.length > 5 }) {
            throw IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.")
        }

        return carNameList
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
}