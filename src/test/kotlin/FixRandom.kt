import kotlin.random.Random

class FixRandom(private val number: Int): Random() {
    override fun nextBits(bitCount: Int): Int {
        return Default.nextBits(number)
    }

    override fun nextInt(bound: Int): Int {
        return number
    }
}
