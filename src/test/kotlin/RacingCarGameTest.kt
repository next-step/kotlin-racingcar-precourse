import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RacingCarGameTest {

    private val randomNumberPicker = RangeRandomNumberPicker(0, 9)

    @Test
    @DisplayName("경주 게임은 자동차 N대를 가진다.")
    fun constructor1() {
        val cars = setOf(Car(CarName("EV3")))
        val racingCarGame = RacingCarGame(cars, 0, randomNumberPicker)

        assertThat(racingCarGame).isNotNull()
            .hasFieldOrPropertyWithValue("cars", cars)
    }

    @Test
    @DisplayName("경주 게임은 play 하면 playCount 1을 소모한다.")
    fun play1() {
        val cars = setOf(Car(CarName("EV3")))
        val racingCarGame = RacingCarGame(cars, 5, randomNumberPicker)

        racingCarGame.play()

        assertThat(racingCarGame).hasFieldOrPropertyWithValue("playCount", 4)
    }

    @Test
    @DisplayName("경주 게임은 play 하면 모든 자동차가 게임을 진행한다.")
    fun play2() {
        val cars = setOf(
            Car(CarName("EV3"), 0),
            Car(CarName("EV6"), 0)
        )
        val movableNumberPicker = object : RandomNumberPicker {
            override fun pick(): Int {
                return 4;
            }
        }
        val racingCarGame = RacingCarGame(cars, 5, movableNumberPicker)
        racingCarGame.play()

        assertThat(racingCarGame.cars()).contains(
            Car(CarName("EV3"), 1),
            Car(CarName("EV6"), 1),
        )
    }

    @Test
    @DisplayName("경주 게임은 playCount가 0인경우 종료상태로 게임을 진행할 수 없다.")
    fun play3() {
        val cars = setOf(Car(CarName("EV3")))
        val racingCarGame = RacingCarGame(cars, 0, randomNumberPicker)

        val throwable = catchThrowable { racingCarGame.play() }
        assertThat(throwable).isInstanceOf(IllegalStateException::class.java)
            .hasMessage("경주 게임이 종료되었습니다.")
    }

    @Test
    @DisplayName("종료상태가 아닌 경우, 우승자를 반환할 수 없다.")
    fun winners1() {
        val cars = setOf(Car(CarName("EV3")))
        val racingCarGame = RacingCarGame(cars, 1, randomNumberPicker)

        val throwable = catchThrowable { racingCarGame.winners() }

        assertThat(throwable).isInstanceOf(IllegalStateException::class.java)
            .hasMessage("종료상태가 아닙니다.");
    }

    @Test
    @DisplayName("우승자는 포지션이 가장 큰 자동차들이다.")
    fun winners2() {
        val winnerCar1 = Car(CarName("EV3"), 10)
        val winnerCar2 = Car(CarName("EV3"), 10)
        val cars = setOf(
            winnerCar1,
            winnerCar2,
            Car(CarName("EV3"), 5),
            Car(CarName("EV3"), 9),
        )
        val racingCarGame = RacingCarGame(cars, 0, randomNumberPicker)

        assertThat(racingCarGame.winners()).containsAll(setOf(winnerCar1, winnerCar2))
    }

    @Test
    @DisplayName("종료상태인지 확인할 수 있다.")
    fun isFinished1() {
        val finishedGame = RacingCarGame(setOf(), 0, randomNumberPicker)
        val noneFinishedGame = RacingCarGame(setOf(), 1, randomNumberPicker)

        assertThat(finishedGame.isFinished()).isTrue()
        assertThat(noneFinishedGame.isFinished()).isFalse()

    }
}