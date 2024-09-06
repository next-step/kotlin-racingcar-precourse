package view

import java.util.*

class InputView {
    private val scanner = Scanner(System.`in`)

    fun inputCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = scanner.nextLine()
        return input.split(",").map { it.trim() }
    }

    fun inputNumberOfAttempts(): Int {
        println("시도할 회수는 몇회인가요?")
        return scanner.nextInt().also { scanner.nextLine() }
    }
}
