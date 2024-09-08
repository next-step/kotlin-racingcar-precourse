package model

import java.util.*

data class CarName (val value: String) {

    init {
        if (Objects.isNull(value) || value.length > 5) {
            throw IllegalArgumentException("자동차 이름은 최대 5자")
        }
    }
}