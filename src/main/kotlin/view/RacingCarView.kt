package view

import controller.RacingController
import model.RacingCar
import model.RacingCarRepository

class RacingCarView() {
    fun getRacingCarInput(): MutableList<RacingCar> {
        val racingCarName = mutableListOf<String>()
        while (true) {
            println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
            val inputNames = readlnOrNull()
            try {
                if (inputNames.isNullOrEmpty()) {
                    throw IllegalArgumentException("경주할 자동차 이름을 입력하세요.")
                }
                val nameList = inputNames.split(",").map { it.trim() }

                for (name in nameList) {
                    if (name.isEmpty()) {
                        throw IllegalArgumentException("빈 이름 입니다. 다시 입력해 주세요")
                    }
                    else if (name.length > 5) {
                        throw IllegalArgumentException("이름이 5글자를 초과했습니다: $name")
                    } else {
                        racingCarName.add(name)
                    }
                }
                break
            } catch (e: IllegalArgumentException) {
                println("[ERROR]: ${e.message}")
            }
        }

        val racingCarList = racingCarName.map { RacingCar(name = it, 0) }.toMutableList()
        return racingCarList
    }

    fun getRacingCountInput(): Int {
        var gameCount: Int? = null
        while (true) {
            println("시도할 횟수는 몇회인가요?")
            try {
                val racingGameCountInput = readlnOrNull() ?: throw IllegalArgumentException("횟수는 0보다 큰 자연수여야 합니다.")

                racingGameCountInput.toIntOrNull() ?: throw IllegalArgumentException("횟수는 0보다 큰 자연수여야 합니다.")

                val racingGameCount = racingGameCountInput.toInt()
                if (racingGameCount <= 0) {
                    throw IllegalArgumentException("횟수는 0보다 큰 자연수여야 합니다.")
                }
                gameCount = racingGameCount
                break
            } catch (e: IllegalArgumentException) {
                println("[ERROR]: ${e.message}.")
            }
        }
        return gameCount!!
    }

    fun printRacingStatus(racingCarList: MutableList<RacingCar>) {
        for (car in racingCarList) {
            val moveResult = "-".repeat(car.moveCnt)
            println(car.name + " : " + moveResult)
        }
        println()
    }

    fun printFinalWinners(finalWinners: String) = println("최종 우승자 : " + finalWinners)
}