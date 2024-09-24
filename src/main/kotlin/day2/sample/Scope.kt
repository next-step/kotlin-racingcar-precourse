package day2.sample

import kotlinx.coroutines.*

val context3: CloseableCoroutineDispatcher = newFixedThreadPoolContext(2, "test")

fun main() {
    runBlocking(context3) {
        // 1
        var job = launch {
            while (true) { // 취소에 협조적이지 않은 코루틴 (isActive 사용가능)
                println("While in ${Thread.currentThread()}")
//                yield()
            }
        }

        // 2
        delay(1000)
        job.cancel()
    }
}
