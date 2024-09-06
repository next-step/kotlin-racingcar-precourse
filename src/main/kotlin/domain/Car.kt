package domain

class Car(
    private var position: Int = 0
) {
    val wherePosition: Int get() = position

    init {
        when{
            position < 0 -> throw IllegalArgumentException("자동차 위치는 음수일 수 없습니다.")
        }
    }

    fun accelerate(value: Int) {
        if (value >= 4) {
            this.position += 1
        }
    }
}
