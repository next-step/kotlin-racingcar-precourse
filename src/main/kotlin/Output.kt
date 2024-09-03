class Output {

    fun printPlayResult(cars: Set<Car>) {
        println()
        println("실행 결과")

        sortedByName(cars).forEach { car ->
            println(car.name().value.plus(" : ").plus("-".repeat(car.position())))
        }
    }

    fun printWinners(winners: Set<Car>) {
        println()
        val winnerNames = sortedByName(winners).joinToString(", ") { car -> car.name().value }
        println("최종 우승자 : ".plus(winnerNames))
    }

    private fun sortedByName(cars: Set<Car>): List<Car> {
        return cars.sortedBy { it.name().value }
    }

}