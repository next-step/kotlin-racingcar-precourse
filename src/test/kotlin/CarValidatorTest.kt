import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CarValidatorTest {
    @Test
    @DisplayName("차량 validator test - 차량명 list가 비어있으면 에러가 발생한다.")
    fun carValidatorTest_CarNameListIsNotEmpty() {
        // given
        val carNames = emptyList<String>()
        val expectedErrorMessage = "차량이 입력되지 않았습니다."

        // when
        val exception = assertThrows(IllegalArgumentException::class.java) {
            CarValidator.validateCarNames(carNames)
        }

        assertThat(exception.message).isEqualTo(expectedErrorMessage)
    }

    @Test
    @DisplayName("차량 validator test - 차량명이 공백이면 에러가 발생한다.")
    fun carValidatorTest_NameIsNotBlank() {
        // given
        val carNames = listOf("  ")
        val expectedErrorMessage = "차량 이름은 비어있으면 안되고, 5자 이하 여야 합니다."

        // when
        val exception = assertThrows(IllegalArgumentException::class.java) {
            CarValidator.validateCarNames(carNames)
        }

        assertThat(exception.message).isEqualTo(expectedErrorMessage)
    }

    @Test
    @DisplayName("차량 validator test - 차량명이 6자 이상이면 에러가 발생한다.")
    fun carValidatorTest_NameLengthLessThan6() {
        // given
        val carNames = listOf("666666")
        val expectedErrorMessage = "차량 이름은 비어있으면 안되고, 5자 이하 여야 합니다."

        // when
        val exception = assertThrows(IllegalArgumentException::class.java) {
            CarValidator.validateCarNames(carNames)
        }

        assertThat(exception.message).isEqualTo(expectedErrorMessage)
    }
}