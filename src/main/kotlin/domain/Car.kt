package domain

import java.util.Random

class Car(
    private val carName: CarName = CarName(),
    private var position: Int = 0
) {
    companion object {
        const val MAX_RANDOM_BOUND = 10
        const val THRESHOLD_TO_MOVE = 4
        const val MOVE_DISTANCE = 1
    }

    val wherePosition: Int get() = position
    val nameForPrint: String get() = carName.nameForPrint

    init {
        when{
            position < 0 -> throw IllegalArgumentException("자동차 위치는 음수일 수 없습니다.")
        }
    }

    fun accelerate(random: Random) {
        if (random.nextInt(MAX_RANDOM_BOUND) >= THRESHOLD_TO_MOVE) {
            this.position += MOVE_DISTANCE
        }
    }
}
