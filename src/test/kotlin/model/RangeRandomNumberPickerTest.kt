package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RangeRandomNumberPickerTest {

    @Test
    @DisplayName("2개의 숫자 사이에서 랜덤 값을 반환한다.")
    fun `pick1`() {
        val `0과 2사이 랜덤 피커` = RangeRandomNumberPicker(0, 2)
        val `4와 6사이 랜덤 피커` = RangeRandomNumberPicker(4, 6)

        repeat(100) {
            assertThat(`0과 2사이 랜덤 피커`.pick()).isBetween(0, 2)
            assertThat(`4와 6사이 랜덤 피커`.pick()).isBetween(4, 6)
        }
    }
}