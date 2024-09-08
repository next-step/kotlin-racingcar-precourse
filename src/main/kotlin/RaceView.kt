object RaceView {
    fun racingView(name : String, move : Int) {
        print(name + " : " + "");
        for (j: Int in 0..move - 1) {
            print("-");
        }
        println();
    }

    fun winnerView(cars: ArrayList<Car>) {
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
}