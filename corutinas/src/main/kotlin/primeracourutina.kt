package org.example

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main() {
    //Una courutina necesita un builder + scope
    //En este caso utilizamos el Scope Global
    //El builder es el método launch
    GlobalScope.launch {
        println("In launch")
    }

    //Si no paramos el thread principal jamás se lanzará la courutina
    Thread.sleep(100)

    println("finished")
}