class CarValidator {
    companion object {
        private const val ERROR_MESSAGE_EMPTY_CAR_NAMES = "차량이 입력되지 않았습니다."
        private const val ERROR_MESSAGE_CAR_NAME_LENGTH = "차량 이름은 5자 이하 여야 합니다."

        fun validateCarNames(carNames: Collection<String>) {
            require(carNames.isNotEmpty()) {
                ERROR_MESSAGE_EMPTY_CAR_NAMES
            }
            require(carNames.all { it.length <= 5 }) {
                ERROR_MESSAGE_CAR_NAME_LENGTH
            }
        }
    }
}