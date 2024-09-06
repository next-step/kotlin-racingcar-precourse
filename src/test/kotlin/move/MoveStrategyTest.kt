package move

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class
MoveStrategyTest{

    @ParameterizedTest
    @ValueSource(ints = [4,5,6,7,8,9])
    fun `0~9사이의 랜덤값이 주어지는데 4이상이면 전진한다`(input : Int){
        //given
        val moveStrategy = MoveStrategy()

        //when
        val result = moveStrategy.isMovable(input)

        //then
        assertTrue(result)
    }

    @ParameterizedTest
    @ValueSource(ints = [0,1,2,3])
    fun `0~9사이의 랜덤값이 주어지는데 4미만이면 전진하지 않는다`(input : Int){
        //given
        val moveStrategy = MoveStrategy()

        //when
        val result = moveStrategy.isMovable(input)

        //then
        assertFalse(result)
    }
}