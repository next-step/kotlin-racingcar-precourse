package com.hyundai.racingcar.model.vo

data class Location(
    val position: Int = 0
) {
    operator fun plus(distance: Int): Location = Location(position + distance)
}
