import kotlin.random.Random

class DrivePolicy {

    val random = Random(System.currentTimeMillis())

    companion object {
        private const val RANDOM_MIN = 0
        private const val RANDOM_MAX = 10
        private const val MIN_MOVE_FORWARD = 4
    }

    fun getMoveForward(): Int {
        val moveForward = random.nextInt(RANDOM_MIN, RANDOM_MAX)
        return if (moveForward >= MIN_MOVE_FORWARD) 1 else 0
    }
}
