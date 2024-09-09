private const val INIT_POSITION: Int = 0

class Car2 {
    var position: Int = INIT_POSITION
}

data class Car(
    val name: String
) {
    var mileage: Int = INIT_POSITION

    init {
        require(name.length <= MAX_NAME_LENGTH) {
            "이름은 5자 이하로 생성해주세요."
        }
    }

    fun drive(mileage: Int) {
        this.mileage += mileage
    }

    // init -> constructor -> fun -> companion object
    companion object {
        private const val MAX_NAME_LENGTH: Int = 5

        fun createCars(carNames: List<String>): List<Car> {
            return carNames.map { Car(it) }
        }
    }
}