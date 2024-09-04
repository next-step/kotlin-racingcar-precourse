package com.hyundai.racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    @DisplayName("자동차에 이름을 부여할 수 있다")
    fun createCar() {
        // given
        val name = "Limhh"

        // when
        val car = Car(name)

        // then
        assertThat(car.name == name)
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
}