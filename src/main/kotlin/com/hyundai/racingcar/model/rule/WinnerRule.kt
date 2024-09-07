package com.hyundai.racingcar.model.rule

import com.hyundai.racingcar.model.Car

interface WinnerRule {
    fun chooseWinners(cars: List<Car>): List<Car>
}