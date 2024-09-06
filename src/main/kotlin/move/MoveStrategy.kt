package move

class MoveStrategy {

    fun isMovable(number: Int): Boolean {
        if (number < MOVE_THRESHOLD)
            return false
        return true
    }

    companion object{
        const val MOVE_THRESHOLD = 4
    }
}