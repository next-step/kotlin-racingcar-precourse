package com.example.randombox

fun main() {
    println("Input racingcar's name. (name can be devided by qutation(,)")

    var nameList = ArrayList<String>()

    loop@while(true) {
        val names = inputNames().split(',')

        for (n in names) {
            if (n.length > 4) {
                println("[ERROR] Invalid name, Please input again.")
                nameList.clear()
                continue@loop
            } else {
                nameList.add(n)
            }
        }
        break
    }
}

fun inputNames() : String {
    val names = readLine().toString()
    return names
}

class RacingCar (name : String ){
    var name = name
}