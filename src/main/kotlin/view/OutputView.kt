package view

import domain.Cars

class OutputView {
    fun printCurrent(cars: Cars) {
        cars.unmodifiableList.forEach {
            val name = it.nameForPrint
            val position = it.position
            val display = "-".repeat(position)
            println("$name : $display")
        }
        println()
    }

    fun printResultHeader() {
        println("실행 결과")
    }

    fun printResultWinner(winners: Cars) {
        val winnerNames = winners.unmodifiableList.joinToString(", ") { it.nameForPrint }
        println("최종 우승자 : $winnerNames")
    }
}
