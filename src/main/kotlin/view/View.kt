package view

import car.Car
import logic.InputUtil
import logic.Logic
import logic.splitName

class View(
    private val logic: Logic,
    private val input: InputUtil,
) {

    fun printInputInfo(): List<String> {
        println("경주에 참여할 참여자들을 입력해주세요")
        println("입력시 이름은 , 으로 구분됩니다.")
        println("입력 예시 :  >>  junuu,hong,chong,ggam << ")
        val result = input.inputName()
        val splitResult = splitName(result)
        println("입력 결과 : $splitResult")
        return splitResult
    }

    fun printWinner(inputCars: List<Car>) : List<String> {
        val result = logic.findWinner(inputCars)
        println("=======우승자========")
        result.forEach {
            println(it)
        }
        return result
    }
}