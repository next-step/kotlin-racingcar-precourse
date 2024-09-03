import java.util.*

class Car constructor(name: String, position: Int = 0) {

    private var name = name
    private var position = position

    init {
        validateCarName(name)
    }

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
        if (randomNumber < 0 || randomNumber > 4) {
            return
        }

         moveForward()
    }


}