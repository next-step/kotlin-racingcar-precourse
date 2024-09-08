package view

import java.lang.RuntimeException

interface View {
    companion object {
        const val ERROR_PREFIX = "[ERROR]"
    }
    fun printErrorMessage(exception: RuntimeException) = println("$ERROR_PREFIX ${exception.message}")
}