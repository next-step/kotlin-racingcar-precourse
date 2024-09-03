import java.util.stream.Collectors

class RacingCarGame constructor(
    cars: Set<Car>,
    private var playCount: Int,
    private var randomNumberPicker: RandomNumberPicker
) {

    private val cars: Set<Car> = cars.stream()
        .map(::Car)
        .collect(Collectors.toSet())

    fun cars():Set<Car> {
        return cars.stream()
            .map(::Car)
            .collect(Collectors.toSet())
    }

    fun play() {
        if (playCount <= 0) {
            throw IllegalStateException("경주 게임이 종료되었습니다.");
        }

        cars.forEach { car -> car.moveForwardByCondition(randomNumberPicker) }
        playCount--
    }

    fun winners(): Set<Car> {
        if (playCount > 0) {
            throw IllegalStateException("종료상태가 아닙니다.")
        }

        val maxPosition = cars.maxOf { it.position() }
        return cars.stream()
            .filter { car -> car.position() == maxPosition }
            .collect(Collectors.toSet()) as Set<Car>
    }

}