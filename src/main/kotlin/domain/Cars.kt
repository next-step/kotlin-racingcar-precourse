package domain

import java.util.*

class Cars(
    private val cars: List<Car>
) {
    init {
        when {
            cars.isEmpty() -> throw IllegalArgumentException("자동차 묶음은 빈값일 수 없다.")
        }
    }

    val unmodifiableList: List<Car> = cars.toList()

    fun move(random: Random) {
        cars.forEach { car -> car.accelerate(random) }
    }

    fun winners(): Cars {
        val maxPosition = cars.maxOf { it.wherePosition }
        return Cars(
            cars.filter { it.wherePosition == maxPosition }
                .toList()
        )
    }
}
