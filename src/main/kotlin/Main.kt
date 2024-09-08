import java.lang.StringBuilder
import java.util.StringTokenizer

fun main() {
    var carNames : List<String>;
    var raceTimes : Int;
    var cars : ArrayList<Car> = ArrayList<Car>();

    // Input names
    NameError@while (true) {
        println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        val command = readln();
        var tempNames = command.trim().split(",");
        for (name in tempNames) {
            try {
                if (name.length > 5) {
                    throw IllegalArgumentException();
                }
            } catch (_: IllegalArgumentException) {
                println("[ERROR] car name is too long...");
                continue@NameError;
            }
        }
        carNames = tempNames;
        break;
    }

    // Input the numbers of times
    NumberError@while (true) {
        println("시도할 횟수는 몇 회인가요?");
        val tempNumber = readln().trim().toIntOrNull();

        try {
            if (tempNumber != null && tempNumber > 0) {
                raceTimes = tempNumber;
                break;
            } else {
                throw IllegalArgumentException();
            }
        } catch (_: IllegalArgumentException) {
            println("[ERROR] input number is wrong...");
            continue@NumberError;
        }
    }

    // Prepare Cars
    carNames.forEach {
        cars.add(Car(it));
    }

    // Start race
    for (i: Int in 0..raceTimes - 1) {
        cars.forEach {
            it.drive();
            RaceView.racingView(it.name, it.move);
        }
        println();
    }

    // Winners
    print("최종 우승자 : ");
    RaceView.winnerView(cars);
}