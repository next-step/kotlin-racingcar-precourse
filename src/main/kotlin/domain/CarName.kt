package domain


class CarName(
    private val name: String = "empty"
) {
    init {
        check(name.isNotBlank()) { "자동차 이름은 빈값일 수 없습니다." }
        check(name.length <= MAXIMUM_NAME_LENGTH) { "자동차 이름은 5자 이하여야 합니다." }
    }

    val nameForPrint: String get() = name

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CarName) return false

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    companion object {
        private const val MAXIMUM_NAME_LENGTH: Int = 5
    }
}
