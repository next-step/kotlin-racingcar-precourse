package com.hyundai.racingcar.model

import com.hyundai.racingcar.model.rule.MoveRule
import com.hyundai.racingcar.model.vo.Location

class Car(
    val name: String,
    private var location: Location = Location()
) {
    val position: Int get() = location.position

    init {
        require(name.isNotBlank()) { "이름은 공백일 수 없습니다." }
        require(name.length <= 5) { "이름은 5자 이하만 가능합니다. (${name}[${name.length}])" }
    }

    fun move(moveRule: MoveRule) {
        if (moveRule.canMove())
            location += 1
    }
}