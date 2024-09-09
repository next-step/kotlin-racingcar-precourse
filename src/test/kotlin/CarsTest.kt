import domain.Car
import domain.Cars
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalStateException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CarsTest {

    @Test
    @DisplayName("자동차 묶음은 빈값일 수 없다.")
    fun empty_exception() {
        assertThatIllegalStateException()
            .isThrownBy { Cars(listOf()) }
            .withMessage("자동차 묶음은 빈값일 수 없다.")
    }

    companion object {
        @JvmStatic
        fun provideAccelerateValues(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(1, 0),
                Arguments.of(2, 0),
                Arguments.of(3, 0),
                Arguments.of(4, 1),
                Arguments.of(5, 1),
                Arguments.of(6, 1),
                Arguments.of(7, 1),
                Arguments.of(8, 1),
                Arguments.of(9, 1)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideAccelerateValues")
    @DisplayName("모든 자동차를 랜덤값에 따라 이동시킨다.")
    fun move(fixNum: Int, position: Int) {
        val moveCar = Car(carName = "MOVE", position = 0)
        val notMoveCar = Car(carName = "NMOVE", position = 0)
        val cars = Cars(listOf(moveCar, notMoveCar))

        cars.move(FixRandom(fixNum))

        assertThat(cars.unmodifiableList.filter { it.position == position }.toList())
            .hasSize(2)
    }

    @Test
    fun winners() {
        val cars = Cars(
            listOf(
                Car(position = 1),
                Car(position = 5),
                Car(position = 6, carName = "WIN1", id = 1),
                Car(position = 6, carName = "WIN2", id = 2),
                Car(position = 4),
                Car(position = 3)
            )
        )

        val actual = cars.winners()

        assertThat(actual.unmodifiableList)
            .hasSize(2)
            .contains(Car(id = 1), Car(id = 2))
    }
}
