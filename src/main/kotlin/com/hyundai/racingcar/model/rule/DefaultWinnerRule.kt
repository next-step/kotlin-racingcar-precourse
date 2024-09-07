package com.hyundai.racingcar.model.rule

import com.hyundai.racingcar.model.Car

class DefaultWinnerRule : WinnerRule {
    override fun chooseWinners(cars: List<Car>): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.stream().filter { it.position == maxPosition }.toList()
    }
}