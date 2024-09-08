package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class CarTest {
    companion object {
        @JvmStatic
        fun provideDistanceAndExpected(): List<Array<Any>> {
            return listOf(
                // 4보다 작은 경우, 0 return
                arrayOf(3, 0),
                // 4와 같은 경우, 4 return
                arrayOf(4, 4),
                // 4 보다 큰 경우 해당 정수 return
                arrayOf(5, 5)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideDistanceAndExpected")
    @DisplayName("car move test")
    fun carMoveTest(randomDistance: Int, expected: Int) {
        // given
        val car = Car("test")

        // when
        car.move(randomDistance)

        // then
        assertThat(car.distance).isEqualTo(expected)
    }
}