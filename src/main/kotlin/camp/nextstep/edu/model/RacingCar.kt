package camp.nextstep.edu.model

import java.util.Random

class RacingCar(
    val name: String,
    var moveSize: Int = 0,
) {
    init {
        if (name.length > 5) {
            throw IllegalArgumentException("[ERROR] length must not be longer than 5")
        }
    }

    fun printFormat(): String {
        var result = "$name : "
        for (i in 1..moveSize) {
            result = result.plus("-")
        }
        return result
    }

    fun addMoveSize() {
        val random = Random()
        val randomNumber = random.nextInt(10)
        if (randomNumber >= 4) {moveSize++}
    }

    fun isWinner(maxMoveSize: Int): Boolean = maxMoveSize == moveSize
}