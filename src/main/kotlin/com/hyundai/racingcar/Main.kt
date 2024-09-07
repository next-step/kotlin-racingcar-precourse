package com.hyundai.racingcar

import com.hyundai.racingcar.controller.RacingCarContoller
import com.hyundai.racingcar.model.rule.DefaultMoveRule
import com.hyundai.racingcar.model.rule.DefaultWinnerRule
import com.hyundai.racingcar.view.RacingCarView

fun main() {
    val view = RacingCarView()
    val controller = RacingCarContoller(view)

    val cars = controller.enterNames()

    val trials = controller.enterTrials()

    val moveRule = DefaultMoveRule()
    controller.moveCars(trials, cars, moveRule)

    val winnerRule = DefaultWinnerRule()
    controller.showWinners(cars, winnerRule)
}