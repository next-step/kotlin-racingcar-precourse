package com.hyundai.racingcar.controller

import com.hyundai.racingcar.model.Car
import com.hyundai.racingcar.view.RacingCarView

class RacingCarContoller(private val view: RacingCarView) {

    fun enterNames(): List<Car> {
        while(true) {
            try {
                val names = view.getNames()
                return names.split(',').map(String::trim).map { Car(it) }.toList()
            } catch (e: IllegalArgumentException) {
                view.printError(e.message)
            }
        }
    }

    fun enterTrials(): Int {
        while(true) {
            try {
                return view.getTrials()
            } catch (e: NumberFormatException) {
                view.printError("숫자를 입력하세요.")
            }
        }
    }
}