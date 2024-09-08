package service

import model.RacingCarModel
import view.RacingCarView
import kotlin.random.Random

class RacingCarService(
    private val models: MutableList<RacingCarModel>,
    private val view: RacingCarView,
){
    fun createRacingCar(cars: List<String>) {
        view.printEmptyLine()
        view.printGameResult()

        models.addAll(cars.map { RacingCarModel(it,0) })
    }

    fun updateRacingCar() {
        models.forEach { model ->
            val randomValue = Random.nextInt(10)
            if (randomValue >= 4) {
                model.race += 1
            }

            view.printRacingCar(model.car, model.race)
        }
        view.printEmptyLine()
    }

    fun findRacingCarWinner() {
        val maxValue = models.maxOfOrNull { it.race }
        val winners = models.filter { it.race == maxValue }.joinToString(", ") { it.car }

        view.printGameWinner(winners)
    }
}