package logic

import logic.splitName
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import view.InputForTest

class InputTest {
    @Test
    fun `이름은 쉼표로 구분한다`() {
        //given
        val inputNames = "junuu,hong,ggam,chong"

        //when
        val result = splitName(inputNames)

        //then
        Assertions.assertEquals(result.size, 4)
        Assertions.assertEquals(result, listOf("junuu", "hong", "ggam", "chong"))
    }

    @Test
    fun `사용자는 자동차 게임 유저를 입력할 수 있다`(){
        //given
        val inputUtil = InputForTest()

        //when
        val result = inputUtil.inputName()

        //then
        Assertions.assertEquals(result, "junuu,hong,chong,ggam")

    }
}