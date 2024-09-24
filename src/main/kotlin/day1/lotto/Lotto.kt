package day1.lotto

class Lotto(
    val numbers: Set<LottoNumber>
) : Set<LottoNumber> by numbers {

    fun List<Int>.toLotto(): List<LottoNumber> {
        return map { LottoNumber(it) }
    }
}