import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RacingCarGameTest {

    private val randomNumberPicker = RangeRandomNumberPicker(0, 9)

    @Test
    @DisplayName("경주 게임은 자동차 N대를 가진다.")
    fun constructor1() {
        val cars = setOf(Car("EV3"))
        val racingCarGame = RacingCarGame(cars, 0, randomNumberPicker)

        assertThat(racingCarGame).isNotNull()
            .hasFieldOrPropertyWithValue("cars", cars)
    }

    @Test
    @DisplayName("경주 게임은 count가 0이되면 종료된다.")
    fun play1() {
        val cars = setOf(Car("EV3"))
        val racingCarGame = RacingCarGame(cars, 10, randomNumberPicker)

        racingCarGame.play()
        assertThat(racingCarGame).hasFieldOrPropertyWithValue("playCount", 0)
    }

    @Test
    @DisplayName("종료상태가 아닌 경우, 우승자를 반환할 수 없다.")
    fun winners1() {
        val cars = setOf(Car("EV3"))
        val racingCarGame = RacingCarGame(cars, 1, randomNumberPicker)

        val throwable = catchThrowable { racingCarGame.winners() }

        assertThat(throwable).isInstanceOf(IllegalStateException::class.java)
            .hasMessage("종료상태가 아닙니다.");
    }

    @Test
    @DisplayName("우승자는 포지션이 가장 큰 자동차들이다.")
    fun winners2() {
        val winnerCar1 = Car("EV3", 10)
        val winnerCar2 = Car("EV6", 10)
        val cars = setOf(
            winnerCar1,
            winnerCar2,
            Car("K5", 5),
            Car("K8", 9),
        )
        val racingCarGame = RacingCarGame(cars, 0, randomNumberPicker)

        assertThat(racingCarGame.winners()).containsAll(setOf(winnerCar1, winnerCar2))
    }
}