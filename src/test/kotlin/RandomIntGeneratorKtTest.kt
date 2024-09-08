import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class RandomIntGeneratorKtTest {
    @Test
    @DisplayName("무작위 int 생성 로직 test - from이 to 보다 큰 경우, 에러 발생")
    fun randomIntTest_fromIsGreaterThanTo() {
        // given
        val from = 10
        val to = from - 1

        // when & then
        assertThrows(IllegalArgumentException::class.java) {
            randomInt(from, to)
        }
    }

    @Test
    @DisplayName("무작위 int 생성 로직 test - from이 to와 같은 경우")
    fun randomIntTest_fromIsEqualTo() {
        // given
        val from = 10
        val to = from

        // when
        val random = randomInt(from, to)

        // then
        assertThat(random).isEqualTo(from)
    }

    @Test
    @DisplayName("무작위 int 생성 로직 test")
    fun randomIntTest() {
        // given
        val from = 0
        val to = 10

        // when
        val random = randomInt(from, to)

        // then
        assertThat(random).isGreaterThanOrEqualTo(from)
        assertThat(random).isLessThanOrEqualTo(to)
    }
}