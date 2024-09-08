package model

import kotlin.random.Random

class RangeRandomNumberPicker(
    private val start: Int,
    private val end: Int
) : RandomNumberPicker {

    override fun pick(): Int {
        return Random.nextInt(start, end + 1)
    }
}