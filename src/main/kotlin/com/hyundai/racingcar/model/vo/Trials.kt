package com.hyundai.racingcar.model.vo

data class Trials(val count: Int) {
    init {
        require(count > 0) {"0보다 커야합니다."}
    }
}
