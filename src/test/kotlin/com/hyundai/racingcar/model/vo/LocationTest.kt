package com.hyundai.racingcar.model.vo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class LocationTest {

    @Nested
    @DisplayName("연산자 오버로딩")
    inner class OperatorOverloadingTest {

        @Test
        @DisplayName("더하기")
        fun testPlus() {
            //given. when
            val location = Location(1) + 1

            //then
            assertThat(location).isEqualTo(Location(2))
        }
    }
}