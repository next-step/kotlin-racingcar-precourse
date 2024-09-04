package com.hyundai.racingcar.view

class RacingCarView {
    fun getNames():String {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        return readln()
    }

    fun getTrials(): Int {
        println("시도할 회수는 몇회인가요?")
        return readln().toInt()
    }

    fun printError(message: String?) {
        println("[ERROR] ${message?: "다시 입력하세요."}")
    }
}