package view

class RegisterCarView : View {
    companion object {
        const val CAR_NAME_INPUT_TEXT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    }

    fun printCarNameInputMessage() {
        println(CAR_NAME_INPUT_TEXT)
    }

    fun scanCarNames(): String {
        return readln()
    }
}