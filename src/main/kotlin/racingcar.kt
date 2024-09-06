package com.example.randombox

import java.io.BufferedReader

fun main() {
    var carList = ArrayList<RacingCar>()
    var winners = ArrayList<RacingCar>()
    var numOfTry = 0

    loop1@while(true) {
        println("Input racingcar's name. (name can be devided by qutation(,)")
        val names = inputNames().split(',')
        for (n in names) {
            if (n.length > 4) {
                println("[ERROR] Invalid name, Please input again.")
                carList.clear()
                continue@loop1
            } else {
                val car = RacingCar(n.trim())
                carList.add(car)
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
            println("[ERROR] Invalid number.")
            continue@loop2
        }
    }


    println("The results of racing")
    while (numOfTry > 0) {
        for(car in carList) {
            car.doRace()
            println(car.progress)
        }
        println("")
        numOfTry--
    }

    carList.sortWith(compareBy({it.advancedNumber}))
    val winner = carList.maxWith(compareBy({it.advancedNumber}))

    var namesOfWinner = ""

    for (car in carList.asReversed()) {
        if(car.advancedNumber == winner.advancedNumber) {
            if(namesOfWinner.length > 0)
                namesOfWinner += ", "
            namesOfWinner += car.name
        } else {
            break
        }
    }

    println("Final winner : " + namesOfWinner)
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
    var progress = this.name + " : "
    var advancedNumber = 0

    fun doRace() {
        val number = rand()

        if(number >= 4) {
            progress += "-"
            ++advancedNumber
        }
    }

    fun rand() : Int {
        val numberRange = (0..9)
        return numberRange.random()
    }

    override fun toString() : String {
        return "$advancedNumber, " + progress
    }
}