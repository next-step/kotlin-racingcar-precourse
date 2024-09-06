import car.Car
import logic.splitName
import org.junit.jupiter.api.Test
import random.RandomForTest
import view.InputForTest

class IntegratedTest {
    @Test
    fun `사용자는 이름을 입력하고 게임을 진행하여 우승자를 찾을 수 있다`() {
        //given
        val carGame = CarGame(
            inputUtil = InputForTest(),
            randomUtil = RandomForTest(),
        )

        //when
        carGame.run()

        //then
        //RandomForTest()의 경우 3만 반환하며, InputForTest()는 junuu,hong,chong,ggam만 반환합니다.
        //따라서 결과는 항상 모두 0칸을 가며 우승자는 모두입니다.

    }
}