package com.hyundai.racingcar.model.rule

import kotlin.random.Random

class DefaultMoveRule(private val random: Random = Random) : MoveRule {
    override fun canMove(): Boolean {
        return random.nextBoolean()
    }
}