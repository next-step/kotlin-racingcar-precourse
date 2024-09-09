package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    @DisplayName("자동차는 이름을 가진다.")
    fun name1() {
        val car = Car(CarName("EV3"))

        assertThat(car.name()).isEqualTo(CarName("EV3"))
    }

    @Test
    @DisplayName("자동차는 포지션을 가지며, 기본 position은 0이다.")
    fun position1() {
        val ev3 = Car(CarName("EV3"));
        val ev6 = Car(CarName("EV6"), 3);

        assertThat(ev3.position()).isEqualTo(0);
        assertThat(ev6.position()).isEqualTo(3);
    }

    @Test
    @DisplayName("랜덤으로 뽑은 값이 4이상이라면, 전진한다.")
    fun moveForwardByCondition1() {
        val defaultPosition = 0
        val ev3 = Car(name = CarName("EV3"), position = defaultPosition)
        val movableNumberPicker = object : RandomNumberPicker {
            override fun pick(): Int {
                return 4;
            }
        }

        ev3.moveForwardByCondition(movableNumberPicker);

        assertThat(ev3.position()).isEqualTo(defaultPosition + 1);
    }

    @Test
    @DisplayName("랜덤으로 뽑은 값이 4미만이라면, 움직이지 않는다.")
    fun moveForwardByCondition2() {
        val defaultPosition = 0
        val ev3 = Car(name = CarName("EV3"), position = defaultPosition)
        val immovableNumberPicker = object : RandomNumberPicker {
            override fun pick(): Int {
                return 3;
            }
        }

        ev3.moveForwardByCondition(immovableNumberPicker);

        assertThat(ev3.position()).isEqualTo(defaultPosition);
    }
}