package com.hyundai.racingcar.controller

import com.hyundai.racingcar.model.Car
import com.hyundai.racingcar.view.RacingCarView

class RacingCarContoller(private val view: RacingCarView) {

    fun enterNames(): List<Car> {
        val names = view.enterNames()
        return names.split(',').map(String::trim).map { Car(it) }.toList()
    }

}