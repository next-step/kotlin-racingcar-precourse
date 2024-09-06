package com.example.randombox

fun main() {
    var nameList = ArrayList<RacingCar>()
    var numOfTry = 0

    loop1@while(true) {
        println("Input racingcar's name. (name can be devided by qutation(,)")
        val names = inputNames().split(',')
        for (n in names) {
            if (n.length > 4) {
                println("[ERROR] Invalid name, Please input again.")
                nameList.clear()
                continue@loop1
            } else {
                val car = RacingCar(n)
                nameList.add(car)
            }
        }
        break
    }

    loop2@while(true) {
        println("How many times will you try? ")
        numOfTry = inputTryNum()

        if(numOfTry > 0) {
            break;
        } else {
            println("[ERROR] Invalid number")
            continue@loop2
        }
    }
}

fun inputNames() : String {
    val names = readLine()!!.trim().toString()
    return names
}

fun inputTryNum() : Int {
    var tryNum = 0
    try {
        tryNum = readLine()!!.trim().toInt()
    } catch ( e: NumberFormatException) {
        return -1
    }

    return tryNum
}

class RacingCar (name : String ){
    var name = name
}