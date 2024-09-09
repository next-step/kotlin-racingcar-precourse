package domain

import java.util.UUID
import kotlin.random.Random

class Car(
    private val carName: CarName = CarName(),
    position: Int = 0,
    id: Int = UUID.randomUUID().hashCode(),
) {
    var position: Int = position
        private set
    var id: Int = id
        private set

    init {
        check(position >= 0) { "자동차 위치는 음수일 수 없습니다." }
    }

    constructor(carName: String, position: Int, id: Int) : this(CarName(carName), position, id)
    constructor(carName: String, position: Int) : this(CarName(carName), position)
    constructor(carName: String) : this(CarName(carName))

    val nameForPrint: String get() = carName.nameForPrint

    fun accelerate(random: Random) {
        if (random.nextInt(MAX_RANDOM_BOUND) >= THRESHOLD_TO_MOVE) {
            this.position += MOVE_DISTANCE
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        return id == other.id
    }

    override fun hashCode(): Int {
        return id
    }

    companion object {
        const val MAX_RANDOM_BOUND = 10
        const val THRESHOLD_TO_MOVE = 4
        const val MOVE_DISTANCE = 1
    }
}
