package view

import car.Car
import logic.InputUtil
import logic.Logic
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ViewTest {

    @Test
    fun `input 값에 대해서 split된 결과가 반환된다`(){
        //given
        val view = View(
            logic = Logic(),
            input = InputForTest(),
        )

        //when
        val result = view.printInputInfo()

        //then
        Assertions.assertEquals(result, listOf("junuu","hong","chong","ggam"))
    }

    @Test
    fun `우승자 정보가 반환된다`(){
        //given
        val view = View(
            logic = Logic(),
            input = InputForTest(),
        )

        val junuu = Car(
            participantName = "junuu",
            position = 2,
        )
        val hong = Car(
            participantName = "hong",
            position =  2,
        )
        val chong = Car(
            participantName = "chong",
            position = 1,
        )

        val input = listOf(junuu, hong, chong)

        //when
        val result = view.printWinner(input)

        //then
        Assertions.assertEquals(result, listOf("junuu","hong"))
    }
}

class InputForTest : InputUtil{
    override fun inputName(): String {
        return "junuu,hong,chong,ggam"
    }

}