package racingcar.view

import racingcar.model.Car

class RaceView {
    fun printCarNameGuide() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printCarStatusList(carList: List<Car>) {
        carList.forEach { car: Car ->
            println("${car.name} : ${"-".repeat(car.position)}")
        }
    }
}
