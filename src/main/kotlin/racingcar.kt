package com.example.randombox

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    var carList = ArrayList<RacingCar>()
    var numOfTry = 0

    loop1@while(true) {
        println("Input racingcar's name. (name can be devided by qutation(,)")
        try {
            inputNames(carList)
        } catch (e: IllegalArgumentException) {
            println("[ERROR] Invalid name, Please input again.")
            continue@loop1
        }
        break
    }

    loop2@while(true) {
        println("How many times will you try? ")
        try {
            numOfTry = inputTryNum()
        } catch (e: IllegalArgumentException) {
            println("[ERROR] Invalid Number, Please input again.")
            continue@loop2
        }
        break
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

fun inputNames(list: ArrayList<RacingCar>) {
    val names = readLine()!!.trim().toString().split(',')

    for (n in names) {
        if (n.length > 4) {
            throw IllegalArgumentException("e: IllegalArgumentException")
            list.clear()
        } else {
            val car = RacingCar(n.trim())
            list.add(car)
        }
    }
}

fun isNumber(s: String?): Boolean {
    return if (s.isNullOrEmpty()) false else s.all { Character.isDigit(it) }
}

fun inputTryNum(): Int {
    val tryNum = readLine()!!.trim()
    if(!isNumber(tryNum)) {
        throw IllegalArgumentException("e: IllegalArgumentException")
    } else {
        return tryNum.toInt()
    }
}

class RacingCar(name: String) {
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

    fun rand(): Int {
        val numberRange = (0..9)
        return numberRange.random()
    }

    override fun toString(): String {
        return "$advancedNumber, " + progress
    }
}