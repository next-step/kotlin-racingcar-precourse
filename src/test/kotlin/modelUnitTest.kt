import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.assertj.core.api.Assertions.*
import kotlin.random.Random
import Application.*

class CarTest {
    @Test
    fun `자동차 생성 시 이름과 초기 위치가 올바르게 설정된다`() {
        val car = Car("TestCar")
        assertThat(car.name).isEqualTo("TestCar")
        assertThat(car.position).isZero()
    }

    @Test
    fun `자동차 이동 시 위치가 증가할 수 있다`() {
        val fixedRandom = Random(4) // 4 이상의 값을 반환하도록 시드 설정
        val car = Car("TestCar", fixedRandom)
        val initialPosition = car.position
        car.move()
        assertThat(car.position).isGreaterThan(initialPosition)
    }

    @Test
    fun `자동차 이동 시 위치가 변하지 않을 수 있다`() {
        val fixedRandom = Random(3) // 3 이하의 값을 반환하도록 시드 설정
        val car = Car("TestCar", fixedRandom)
        val initialPosition = car.position

        car.move()
        assertThat(car.position).isEqualTo(initialPosition)
    }

    @Test
    fun `toString 메서드가 올바른 형식을 반환한다`() {
        val car = Car("TestCar")
        car.setPositionForTesting(3)
        assertThat(car.toString()).isEqualTo("TestCar : ---")
    }
}

class RaceGameTest {
    private lateinit var game: RaceGame
    private lateinit var cars: List<Car>

    @BeforeEach
    fun setup() {
        cars = listOf(Car("Car1"), Car("Car2"), Car("Car3"))
        game = RaceGame(cars, 5)
    }

    @Test
    fun `게임 초기 상태가 올바르게 설정된다`() {
        assertThat(game.isFinished()).isFalse()
        assertThat(game.getCars()).hasSize(3)
    }

    @Test
    fun `nextTurn 호출 시 자동차들이 이동한다`() {
        val initialPositions = game.getCars().map { it.position }
        game.nextTurn()
        val newPositions = game.getCars().map { it.position }
        assertThat(newPositions).isNotEqualTo(initialPositions)
    }

    @Test
    fun `지정된 횟수만큼 턴이 진행되면 게임이 종료된다`() {
        repeat(5) { game.nextTurn() }
        assertThat(game.isFinished()).isTrue()
    }

    @Test
    fun `우승자가 올바르게 결정된다`() {
        // 수동으로 자동차 위치 설정
        cars[0].setPositionForTesting(3)
        cars[1].setPositionForTesting(5)
        cars[2].setPositionForTesting(5)

        val winners = game.getWinners()
        assertThat(winners).containsExactlyInAnyOrder("Car2", "Car3")
    }
}