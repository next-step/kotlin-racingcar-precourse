import domain.CarName
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarNameTest {

    @Test
    @DisplayName("각 자동차에 이름을 부여할 수 있다.")
    fun name() {
        val actual = CarName("car")
        assertThat(actual).isEqualTo(CarName("car"))
    }

    @Test
    @DisplayName("각 자동차에 이름은 빈값일 수 없다.")
    fun name_exception() {
        assertThatIllegalStateException()
            .isThrownBy { CarName(" ") }
            .withMessage("자동차 이름은 빈값일 수 없습니다.")
    }
}
