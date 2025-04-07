package org.example

import kotlinx.coroutines.*

suspend fun main() {
    //Realizaría las peticiones
    //Hemos colocado el Deferred, porque se inicializa después en diferido
    val job: Deferred<String> = GlobalScope.async {
        println("Lanzamos petición")
        delay(1000)
        "HTTP 200"
    }

    //Lanzamos y esperamos
    val result = job.await()

    println(result)
}
