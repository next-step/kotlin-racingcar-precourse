package camp.nextstep.edu.model

class RacingCar(
    name: String
) {
    init {
        if (name.length > 5) {
            throw IllegalArgumentException("[ERROR] length must not be longer than 5")
        }
    }
}