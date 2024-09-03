package com.hyundai.racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차에 이름을 부여할 수 있다`() {
        val name = "Lim"
        val car = Car(name)

        assertThat(car.name == name)
    }
}