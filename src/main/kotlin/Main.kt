import java.lang.StringBuilder
import java.util.StringTokenizer

fun main() {
    var carNames : List<String>;
    var raceTimes : Int;
    var cars : ArrayList<Car> = ArrayList<Car>();
    var inputError : Boolean = false;

    // Input names
    while (true) {
        println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        val command = readln();
        var tempNames = command.split(",");
        tempNames.forEach Break@{
            if (it.length > 5) {
                println("글자 수가 너무 커");
                inputError = true;
                return@Break;
            }
        }
        if (inputError != true) {
            carNames = tempNames;
            break;
        } else {
            inputError = false;
        }
    }

    // Input the numbers of times
    while (true) {
        println("시도할 횟수는 몇 회인가요?");
        val tempNumber = readln().toIntOrNull();

        if (tempNumber != null && tempNumber > 0) {
            raceTimes = tempNumber;
            break;
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
            print(it.name + " : " + "");
            for (j: Int in 0..it.move - 1) {
                print("-");
            }
            println();
        }
        println();
    }

    // Winners
    print("최종 우승자 : ");
    cars.sortByDescending { it.move }
    val bestMove = cars[0].move;
    print(cars[0].name);
    cars.forEach {
        if (it.move == bestMove && it.name != cars[0].name) {
            print(", " + it.name);
        }
    }
    println();
}