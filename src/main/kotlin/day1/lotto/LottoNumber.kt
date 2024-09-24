package day1.lotto

@JvmInline
value class LottoNumber2(
    private val number: Int
)

class LottoNumber(
    private val number: Int
) {
    init {
        require(number in 1..45) {
            "로또 번호는 1부터 45까지입니다."
        }
    }

    companion object {
        private val NUMBERS: Map<Int, LottoNumber> = (1..45).associateWith(::LottoNumber)

        fun from(number: Int): LottoNumber {
            return NUMBERS.get(number) ?: throw IllegalArgumentException()
        }
    }
}