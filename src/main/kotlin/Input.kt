class Input private constructor() {

    companion object {

        fun readCarNames(): Set<CarName> {
            return readInputWithRetry {
                println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)")
                readln().split(",")
                    .map { CarName(it.trim()) }
                    .toSet()
            }
        }

        fun readPlayCount(): Int {
            return readInputWithRetry {
                println("시도할 횟수는 몇회인가요?")
                readln().toInt()
            }
        }

        private fun <T> readInputWithRetry(action: () -> T): T {
            return try {
                action()
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ".plus(e.message + "\n"))
                readInputWithRetry(action)
            }
        }
    }
}