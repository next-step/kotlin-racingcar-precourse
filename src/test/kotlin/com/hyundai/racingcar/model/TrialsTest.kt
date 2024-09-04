package com.hyundai.racingcar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TrialsTest {

    @Test
    @DisplayName("이동 횟수는 0보다 커야한다")
    fun trialsShouldBeMoreThanZero() {
        // given, when, then
        Assertions.assertThatThrownBy {Trials(0)}
            .hasMessage("0보다 커야합니다.")
    }

}