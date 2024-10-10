package day1.racingcar

class DrivePolicy {

    fun getMoveForward(): Int {
        val moveForward = (RANDOM_MIN..RANDOM_MAX).random()
        return if (moveForward >= MIN_MOVE_FORWARD) 1 else 0
    }

    companion object {
        private const val RANDOM_MIN = 0
        private const val RANDOM_MAX = 9
        private const val MIN_MOVE_FORWARD = 4
    }
}
