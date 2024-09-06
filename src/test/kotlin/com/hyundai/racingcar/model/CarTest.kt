package com.hyundai.racingcar.model

import com.hyundai.racingcar.model.rule.MoveRule
import com.hyundai.racingcar.model.vo.Location
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CarTest {

    @Test
    @DisplayName("자동차에 이름을 부여할 수 있다")
    fun createCar() {
        // given
        val name = "Limhh"

        // when
        val car = Car(name)

        // then
        assertThat(car.name).isEqualTo("Limhh")
    }

    @Test
    @DisplayName("이름은 5자 이하만 가능하다")
    fun nameShouldBeLessThanFiveCharacters() {
        //given, when, then
        assertThatThrownBy {Car("6chars")}
            .hasMessage("이름은 5자 이하만 가능합니다. (6chars[6])")
    }

    @Test
    @DisplayName("이름은 공백일 수 없다")
    fun nameCannotBeBlank() {
        //given, when, then
        assertThatThrownBy {Car(" ")}
            .hasMessage("이름은 공백일 수 없습니다.")
    }

    @DisplayName("자동차는 전진 또는 멈출 수 있다")
    @ParameterizedTest
    @MethodSource("movabilityAndPositionProvider")
    fun positionIncreasesByOneWhenCarMove(canMove: Boolean, initPos: Int, expectedPos: Int) {
        //given
        val car = Car("name", Location(initPos))
        val moveRule = object : MoveRule {
            override fun canMove(): Boolean {
                return canMove
            }
        }

        //when
        car.move(moveRule)

        //then
        assertThat(car.position).isEqualTo(expectedPos)
    }

    companion object {
        @JvmStatic
        fun movabilityAndPositionProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(true, 0, 1),
                Arguments.of(true, 1, 2),
                Arguments.of(false, 1, 1),
                Arguments.of(false, 0, 0)
            )
        }
    }
}