package model

class Car(
    val name: String,
    var distance: Int = MIN_MOVE_DISTANCE
) {
    companion object {
        private const val MOVE_THRESHOLD = 4
        private const val MIN_MOVE_DISTANCE = 0
    }

    fun move(randomDistance: Int) {
        distance += calculateDistance(randomDistance)
    }

    private fun calculateDistance(randomDistance: Int): Int {
        if (randomDistance >= MOVE_THRESHOLD) {
            return randomDistance
        }
        return MIN_MOVE_DISTANCE
    }
}