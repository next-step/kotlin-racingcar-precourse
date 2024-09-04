package com.hyundai.racingcar.model

data class Car (val name:String) {
    init {
        require(name.isNotBlank()) {"이름은 공백일 수 없습니다."}
        require(name.length <= 5) {"이름은 5자 이하만 가능합니다. (${name}[${name.length}])"}
    }

}