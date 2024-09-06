package com.hyundai.racingcar.model.rule

import kotlin.random.Random
import kotlin.random.nextInt

class DefaultMoveRule(private val random: Random = Random) : MoveRule {
    override fun canMove(): Boolean {
        return random.nextInt(0..9) >= 4
    }
}