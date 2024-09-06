package com.hyundai.racingcar.view

import com.hyundai.racingcar.model.Car

class RacingCarView {
    fun getNames():String {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        return readln()
    }

    fun getCounts(): Int {
        println("시도할 회수는 몇회인가요?")
        return readln().toInt()
    }

    fun printError(message: String?) {
        println("[ERROR] ${message?: "다시 입력하세요."}")
    }

    fun printResultMessage() {
        println("실행 결과")
    }

    fun printResult(cars: List<Car>) {
        cars.forEach { println("${it.name} : ${"-".repeat(it.position)}")}
        println()
    }
}