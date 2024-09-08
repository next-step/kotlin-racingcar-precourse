package racingcar.view

import racingcar.model.Car

class RaceView {
    fun printCarNameGuide() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printPlayCountGuide() {
        println("시도할 회수는 몇회인가요?")
    }

    fun printCarStatusList(carList: List<Car>) {
        println()
        carList.forEach { car: Car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
    }

    fun printWinner(winnerList: List<Car>) {
        println("최종 우승자 : ${winnerList.joinToString(", ") { it.name }}")
    }
}
