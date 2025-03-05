/*
    1.- Revisar estructura sencilla
    2.- Completa
    3.- Or AND
*/

fun main() {

    /*
    * In Kotlin, if is an expression: it returns a value.
    * Therefore, there is no ternary operator (condition ? then : else) because ordinary
    * if works fine in this role.
    *
    * */
    print("Introduce un numero: ")
    var a= readln().toInt()
    print("Introduce un numero: ")
    var b= readln().toInt()
    var max = a
    if (a < b) max = b
    println("El máximo numero es=$max")

    // With else
    if (a > b) {
        max = a
    } else {
        max = b
    }

    // As expression
    max = if (a > b) a else b

    // You can also use `else if` in expressions:
    val maxLimit = 1
    val maxOrLimit = if (maxLimit > a) maxLimit else if (a > b) a else b

    // Operaciones logicas
    val pet = "cat"
    val isHappy = true

    if(pet == "dog" || (pet == "cat" && isHappy)){
        print("Es un gato o un perro")
    }

    val age = 18
    val parentPermission = false
    val imHappy = true

    if(age >= 18 && parentPermission && imHappy){
        println("Puedo beber cerveza")
    }

    var soyFeliz:Boolean = false

    //sin nada == true
    // con ! al principio == false

    if(!soyFeliz){
        print("Estoy triste :(")
    }

    //Anidado
    val animal = "perro"

    if (animal == "perro") {
        println("Es un perrito!")
    } else if (animal == "gato") {
        println("Es un gato")
    } else if (animal == "pajaro") {
        println("Es un pajaro")
    } else {
        println("No es uno de los animales esperados")
    }
}