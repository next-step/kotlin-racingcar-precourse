package com.hyundai.racingcar.model.rule

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.random.Random

class DefaultMoveRuleTest {

    @ParameterizedTest
    @DisplayName("무작위 값이 4 이상일 경우 이동할 수 있다")
    @MethodSource("randomIntAndMovabilityProvider")
    fun canMoveIfRandomValueIsMoreOrEqualThanFour(randomValue: Int, canMove: Boolean) {
        //given
        val random = object : Random() {
            override fun nextBits(bitCount: Int): Int {
                return 0
            }

            override fun nextInt(from: Int, until: Int): Int {
                return randomValue
            }
        }
        val moveRule = DefaultMoveRule(random)

        //when, then
        assertThat(moveRule.canMove()).isEqualTo(canMove)
    }

    companion object {

        @JvmStatic
        fun randomIntAndMovabilityProvider():Stream<Arguments> {
            return Stream.of(
                Arguments.of(0, false),
                Arguments.of(1, false),
                Arguments.of(2, false),
                Arguments.of(3, false),
                Arguments.of(4, true),
                Arguments.of(5, true),
                Arguments.of(6, true),
                Arguments.of(7, true),
                Arguments.of(8, true),
                Arguments.of(9, true),
            )
        }
    }

}