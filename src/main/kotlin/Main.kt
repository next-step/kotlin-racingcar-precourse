fun main(args: Array<String>) {
    val cars = Input.readCarNames()
        .map(::Car)
        .toSet()
    val playCount = Input.readPlayCount();

    val racingCarGame = RacingCarGame(cars, playCount, RangeRandomNumberPicker(0, 9))

    while (!racingCarGame.isFinished()) {
        racingCarGame.play()
        Output.printPlayResult(racingCarGame.cars())
    }

    Output.printWinners(racingCarGame.winners())
}