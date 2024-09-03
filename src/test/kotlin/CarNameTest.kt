import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarNameTest {

    @Test
    @DisplayName("자동차 이름은 최대 5자이다.")
    fun name2() {

        val ev3Name = CarName("EV3")
        val throwable = catchThrowable { CarName("The New EV6") }

        assertThat(throwable).isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차 이름은 최대 5자")
        assertThat(ev3Name.value).isEqualTo("EV3");
    }
}