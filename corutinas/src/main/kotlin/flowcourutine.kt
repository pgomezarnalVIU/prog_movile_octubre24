package org.example

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow

suspend fun main() {

    // En el otro lado el cliente recogerá todos los datos a modo de subscripción
    emitNumbers().collect {
        println(it)
    }

    println("Finished")
}

//El emisor de datos puede usar flow para mostrar los datos cuando se dispongan
fun emitNumbers() = flow {
    emit(1)
    delay(500)
    emit(2)
    delay(500)
    emit(3)
    delay(500)
    emit(4)
    delay(500)
    emit(5)
}

