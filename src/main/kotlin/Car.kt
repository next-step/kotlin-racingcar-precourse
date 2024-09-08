class Car(nameParam : String){
    var name : String = nameParam;
    var move : Int = 0;

    fun drive() : Boolean {
        val value = (0..9).random();

        if (value >= 4) {
            move++;
            return true;
        }
        return false;
    }
}