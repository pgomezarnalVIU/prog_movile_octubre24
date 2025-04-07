package org.example

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//Necesito que la función donde yo use join/cancel pueda ser suspendida/async
suspend fun main() {
    val job: Job = GlobalScope.launch {
        delay(3000)
        println("In launch")
    }

    job.join()
    //Con el job cancel cancelo la ejecucion
    //job.cancel()

    println("finished")
}

