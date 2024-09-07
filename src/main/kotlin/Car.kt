data class Car (
    val name: String,
    var mileage: Int
) {
    init {
        require(name.length <= 5) {
            "이름은 5자 이하로 생성해주세요."
        }
    }

    companion object {
        fun createCars(carNames: List<String>): List<Car> {
            return carNames.map { Car(it, 0) }
        }
    }

    fun drive(mileage: Int) {
        this.mileage += mileage
    }
}