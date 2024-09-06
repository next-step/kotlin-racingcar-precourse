import logic.Input
import random.Random

fun main(args: Array<String>) {
    val carGame = CarGame(
        inputUtil = Input(),
        randomUtil = Random(),
    )
    carGame.run()
}