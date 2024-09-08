package view

class RoundView : View {
    companion object {
        const val ROUND_INPUT_TEXT = "시도할 회수는 몇회인가요?"
    }

    fun printRoundInputMessage() {
        println(ROUND_INPUT_TEXT)
    }

    fun scanRound(): Int {
        return readln().toInt()
    }
}