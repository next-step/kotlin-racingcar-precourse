package com.hyundai.racingcar.controller

import com.hyundai.racingcar.model.Car
import com.hyundai.racingcar.model.rule.MoveRule
import com.hyundai.racingcar.model.vo.Trials
import com.hyundai.racingcar.view.RacingCarView

class RacingCarContoller(private val view: RacingCarView) {

    fun enterNames(): List<Car> {
        while(true) {
            try {
                val names = view.getNames()
                return names.split(',').map(String::trim).map { Car(it) }.toList()
            } catch (e: IllegalArgumentException) {
                view.printError(e.message)
            } catch (e: NumberFormatException) {
                view.printError(e.message)
            }
        }
    }

    fun enterTrials(): Trials {
        while(true) {
            try {
                return Trials(view.getCounts())
            } catch (e: NumberFormatException) {
                view.printError("숫자를 입력하세요.")
            }
        }
    }

    fun moveCars(trials: Trials, cars: List<Car>, moveRule: MoveRule) {
        for (i in 1..trials.count) {
            cars.forEach { it.move(moveRule) }
        }
    }
}