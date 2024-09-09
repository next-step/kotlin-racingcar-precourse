import domain.Car
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @Test
    fun car_exception() {
        assertThatIllegalStateException()
            .isThrownBy { Car(position = -1) }
            .withMessage("자동차 위치는 음수일 수 없습니다.")
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6])
    @DisplayName("4 이상인 경우 전진한다.")
    fun accelerate1(value: Int) {
        val car = Car()
        car.accelerate(FixRandom(value))
        assertThat(car.wherePosition).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    @DisplayName("3 이하인 경우 그대로다.")
    fun accelerate2(value: Int) {
        val car = Car()
        car.accelerate(FixRandom(value))
        assertThat(car.wherePosition).isEqualTo(0)
    }
}
