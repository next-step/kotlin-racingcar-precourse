package com.hyundai.racingcar

import com.hyundai.racingcar.controller.RacingCarContoller
import com.hyundai.racingcar.view.RacingCarView

fun main() {
    val view = RacingCarView()
    val controller = RacingCarContoller(view)

    val cars = controller.enterNames()
}