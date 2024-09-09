package view

import java.util.*

class InputView {
    private val scanner = Scanner(System.`in`)

    private fun <T> retryOnException(block: () -> T): T {
        while (true) {
            try {
                return block()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun inputCarNames(): List<String> {
        return retryOnException {
            println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
            val input = scanner.nextLine()

            require(input.isNotBlank()) { "[ERROR] 자동차 이름은 공백이나 빈 값이 될 수 없습니다." }
            require(input.split(",").all { it.isNotBlank() }) { "[ERROR] 자동차 이름은 공백이나 빈 값이 될 수 없습니다." }

            input.split(",").map { it.trim() }
        }
    }

    fun inputNumberOfAttempts(): Int {
        return retryOnException {
            println("시도할 회수는 몇 회인가요?")
            val input = scanner.nextLine()
            requireNotNull(input.toIntOrNull()) { "[ERROR] 시도할 회수는 숫자로 입력해 주세요." }

            val numberOfAttempts = input.toInt()
            require(numberOfAttempts >= 1) { "[ERROR] 시도할 회수는 1회 이상이어야 합니다." }

            numberOfAttempts
        }
    }
}
