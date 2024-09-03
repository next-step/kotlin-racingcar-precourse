import java.util.*

class Car(
    private val name: String,
    private var position: Int = 0
) {

    init {
        validateCarName(name)
    }

    constructor(car: Car) : this(car.name, car.position)

    private fun validateCarName(name: String) {
        if (Objects.isNull(name) || name.length > 5) {
            throw IllegalArgumentException("자동차 이름은 최대 5자")
        }
    }

    fun name(): String {
        return name;
    }

    fun position(): Int {
        return position;
    }

    private fun moveForward() {
        this.position += 1;
    }

    fun moveForwardByCondition(randomNumberPicker: RandomNumberPicker) {
        val randomNumber = randomNumberPicker.pick();
        if (isMovableCondition(randomNumber)) {
            moveForward()
        }
    }

    private fun isMovableCondition(randomNumber: Int): Boolean {
        return randomNumber in 0..4;
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        if (name != other.name) return false
        if (position != other.position) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + position
        return result
    }
}