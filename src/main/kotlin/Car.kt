class Car(nameParam : String){
    var name : String = nameParam;

    fun drive() : Boolean {
        val value = (0..9).random();

        if (value >= 4) {
            return true;
        }
        return false;
    }
}