package racingcar.controller

import racingcar.view.RaceView
import java.io.BufferedReader
import java.io.InputStreamReader

class RaceController() {
    private val raceView = RaceView()

    fun play() {
        val carNameList = getCarNameList()
    }

    private fun getCarNameList(): List<String> = with(BufferedReader(InputStreamReader(System.`in`))) {
        raceView.printCarNameGuide()

        val carNameList = readLine().split(",").map { it.trim() }
        if (carNameList.any { it.isEmpty() || it.length > 5 }) {
            throw IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하여야 합니다.")
        }

        return carNameList
    }
}