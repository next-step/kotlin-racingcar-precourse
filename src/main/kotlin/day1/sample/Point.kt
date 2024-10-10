package day1.sample

class Point(
    private val x: Int,
    private val y: Int,
) {
    operator fun plus(other: Point): Point {
        return Point(this.x + other.x, this.y + other.y)
    }

    operator fun get(text: String): Int {
        return when (text) {
            "x" -> this.x
            "y" -> this.y
            else -> throw IllegalArgumentException()
        }
    }
}