package view

class RacingCarView {
    fun enterInputValue(): String? {
        return readlnOrNull()
    }

    fun printCarName() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printRacingCount() {
        println("시도할 회수는 몇회인가요?")
    }

    fun printErrorMessage(message: String?) {
        println("[ERROR] $message")
    }
}