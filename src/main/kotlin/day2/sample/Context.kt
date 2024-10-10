package day2.sample

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

val context: CloseableCoroutineDispatcher = newSingleThreadContext("test")
val context2: CloseableCoroutineDispatcher = newFixedThreadPoolContext(10, "test")

fun main() {
    runBlocking(context2) {
        val time = measureTimeMillis {
            val name = async { asyncGetName() }
            val lastName = async { asyncGetLastName() }
            println("Hello, ${name.await()} ${lastName.await()}")
        }
        println("Execution took $time ms")
    }
}

suspend fun asyncGetName(): String {
    delay(1000)
    return "Jason"
}

suspend fun asyncGetLastName(): String {
    delay(1000)
    return "Park"
}