import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    @Test
    fun `자동차 이름은 5자를 초과하만 예외가 발생한다`() {

       assertThrows<IllegalArgumentException> {
            Car("동해물과백두산이")
        }
    }

    @Test
    fun `자동차 초기 위치는 0이다`() {
        val actual = Car("제이슨")
        assertThat(actual.mileage).isEqualTo(0)
//        actual.mileage shouldBe 0
    }
}