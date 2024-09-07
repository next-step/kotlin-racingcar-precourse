package com.hyundai.racingcar.model.rule

import com.hyundai.racingcar.model.Car
import com.hyundai.racingcar.model.vo.Location
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DefaultWinnerRuleTest {

    @Test
    @DisplayName("가장 멀리 있는 자동차가 우승한다")
    fun carsWithMaxPositionAreWinners() {
        //given
        val car1 = Car("car1", Location(10))
        val car2 = Car("car2", Location(1))
        val car3 = Car("car3", Location(10))
        val cars = listOf(car1, car2, car3)

        val winnerRule = DefaultWinnerRule()

        // when, then
        assertThat(winnerRule.chooseWinners(cars))
            .isEqualTo(listOf(car1, car3))
    }
}