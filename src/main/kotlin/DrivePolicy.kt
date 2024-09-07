import kotlin.random.Random

class DrivePolicy {

    val random = Random(RANDOM_SEED)

    companion object {
        private const val RANDOM_SEED = 10
        private const val MIN_MOVE_FORWARD = 4
    }

    fun getMoveForward(): Long {
        val moveForward = random.nextLong()
        return if (moveForward >= MIN_MOVE_FORWARD) moveForward else 0
    }
}
