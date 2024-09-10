package lotto

class WiningLotto(
    private val lotto: Lotto,
    private val bonus: LottoNumber
) {
    init {
        require(!lotto.contains(bonus))
    }
}