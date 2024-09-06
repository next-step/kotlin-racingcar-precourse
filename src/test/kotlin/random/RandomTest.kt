package random

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RandomTest {
    @Test
    fun `랜덤값이 올바르게 나오는지 테스트`() {
        //given
        val random = RandomForTest()

        //when
        val result = random.generateNumber()

        //then
        Assertions.assertEquals(result, 3)
    }
}

class RandomForTest : RandomUtil {
    override fun generateNumber(): Int {
        return 3
    }
}

