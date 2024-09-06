package com.hyundai.racingcar.model.vo

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TrialsTest {

    @Test
    @DisplayName("이동 횟수는 0보다 커야한다")
    fun trialsShouldBeMoreThanZero() {
        // given, when, then
        assertThatThrownBy { Trials(0) }
            .hasMessage("0보다 커야합니다.")
    }

}