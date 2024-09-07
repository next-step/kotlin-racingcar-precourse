package view

open class RacingCarView {
    open fun enterInputValue(): String? {
        return readlnOrNull()
    }

    open fun printCarName() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    open fun printRacingCount() {
        println("시도할 회수는 몇회인가요?")
    }

    open fun printErrorMessage(message: String?) {
        println("[ERROR] $message")
    }

    open fun printEmptyLine() {
        println()
    }

    open fun printGameResult() {
        println("실행 결과")
    }

    open fun printRacingCar(name: String, race: Int) {
        val track = "-".repeat(race)
        println("$name : $track")
    }

    open fun printGameWinner(winner: String) {
        println("최종 우승자 : $winner")
    }
}