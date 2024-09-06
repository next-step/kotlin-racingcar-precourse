package car

import move.MoveStrategy

class Car(
    val participantName: String,
    position: Int = 0,
    private val moveStrategy: MoveStrategy = MoveStrategy(),
) {

    var position = position
        private set

    init {
        require(participantName.length <= NAME_LENGTH_VALIDATION) {
            throw IllegalArgumentException("이름은 5자 이하여야 합니다.")
        }
    }

    fun move(number : Int){
        if(moveStrategy.isMovable(number)){
            position++
        }
    }

    companion object{
        const val NAME_LENGTH_VALIDATION = 5
    }
}