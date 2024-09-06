package random

import java.security.SecureRandom

interface RandomUtil {
    fun generateNumber(): Int
}

class Random : RandomUtil {
    override fun generateNumber(): Int {
        return secureRandom.nextInt(UPPER_BOUND)
    }

    companion object {
        private val secureRandom = SecureRandom()
        const val UPPER_BOUND = 9
    }
}