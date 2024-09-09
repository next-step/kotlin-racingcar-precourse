package domain

import kotlin.random.Random

class Cars(
    private val cars: List<Car>
) {
    init {
        check(cars.isNotEmpty()) { "자동차 묶음은 빈값일 수 없다." }
    }

    val unmodifiableList: List<Car> = cars.toList()

    fun move(random: Random) {
        cars.forEach { car -> car.accelerate(random) }
    }

    fun winners(): Cars {
        val maxPosition = cars.maxOf { it.position }
        return Cars(
            cars.filter { it.position == maxPosition }
                .toList()
        )
    }
}
