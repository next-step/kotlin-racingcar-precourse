fun main() {
    println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)")
    val namesInput = readLine()
    val carNames = namesInput?.split(",")?.map { it.trim() } ?: listOf()

    println("시도할 회수는 몇회인가요?")
    val attempts = readLine()?.toInt()!!

    val cars = Car.createCars(carNames)
    val drivePolicy = DrivePolicy()

    println("실행 결과")
    repeat(attempts) {
        cars.forEach {
            it.drive(drivePolicy.getMoveForward())
            println("${it.name} : ${"-".repeat(it.mileage)}")
        }
        println()
    }

    val maxMileage = cars.map { it.mileage }.max()
    val winnerNames = cars.filter { it.mileage == maxMileage }.map { it.name }
    println("최종 우승자 : ${winnerNames.joinToString(", ")}")
}