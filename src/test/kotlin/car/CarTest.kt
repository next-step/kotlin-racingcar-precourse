package car

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = ["junuu","hong"])
    fun `참여자 이름으로 차를 생성`(input: String){
        //given

        //when
        val car = Car(participantName = input)

        //then
        Assertions.assertNotNull(car)
        Assertions.assertEquals(car.participantName, input)
    }

    @ParameterizedTest
    @ValueSource(strings = ["junuu1","hong35"])
    fun `참여자의 이름은 5자 이하여야 한다`(input: String){
        //given

        //when, then
        Assertions.assertThrows(IllegalArgumentException::class.java){
            Car(participantName = input)
        }
    }

    @Test
    fun `랜덤값으로 4,5,2가 호출되면 위치는 2칸 전진해야 한다`(){
        //given
        val car = Car(participantName = "junuu")

        //when
        car.move(4)
        car.move(5)
        car.move(2)

        //then
        Assertions.assertEquals(car.position, 2)
    }
}