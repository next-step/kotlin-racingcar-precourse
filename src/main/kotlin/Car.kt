data class Car (
    val name: String,
    var mileage: Long
) {
    init {
        require(name.length <= 5) {
            "이름은 5자 이하로 생성해주세요."
        }
    }

    fun drive(mileage: Long) {
        this.mileage += mileage
    }
}