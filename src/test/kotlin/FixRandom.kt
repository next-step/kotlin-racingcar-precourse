import java.util.Random

class FixRandom(private val number: Int): Random() {
    override fun nextInt(bound: Int): Int {
        return number
    }
}
