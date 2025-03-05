/*
* 1.- Prototipo de las funciones
* 2.- Varios parámetros
* 3.- Parámetros por defecto
* 4.- Single expresion
* 5.- Pasos por valor, arrays
* 6.- Mutabilidad de objetos y arrays
*/

fun main(){
    //Uso de funciones
    val valorX:Int = 2;
    val valorY:Int = 1;
    val resultDoble = simpleDouble(valorX)
    println("El doble de $valorX es $resultDoble")
    val resultSumaPon = sumaPon(valorX,valorY)
    println("La suma ponderada de $valorX,$valorY es $resultSumaPon")
    val sumaPonDef = sumaPonDef(valorX)

    // Named arguments
    // When calling this function, you don't have to name all its arguments:
    reformat(
        "String!",
        false,
        upperCaseFirstLetter = false,
        divideByCamelHumps = true,
        '_'
    )

    // Unit-returning functions
    printHello("Paco")
}

//Kotlin functions are declared using the fun keyword:
fun simpleDouble(x: Int): Int {
    return 2 * x
}
fun double(x: Int): Int = x * 2 //Otra forma, _Single expresion

//Suma ponderada de dos parámetros
// Function parameters are defined using Pascal notation - name: type.
// Parameters are separated using commas, and each parameter must be explicitly typed:
fun sumaPon(x: Int,y:Int): Int {
    return (2 * x)+y
}

//Suma ponderada de dos parámetros con valor por defecto
fun sumaPonDef(x: Int,y:Int=0): Int {
    return (2 * x)+y
}

// Named arguments
//Consider the reformat() function, which has 4 arguments with default values.
fun reformat(
    str: String,
    normalizeCase: Boolean = true,
    upperCaseFirstLetter: Boolean = true,
    divideByCamelHumps: Boolean = false,
    wordSeparator: Char = ' ',
) { /*...*/ }

/*
* Unit-returning functions
* If a function does not return a useful value,
* its return type is Unit. Unit is a type with only one value - Unit.
* This value does not have to be returned explicitly:
* */

fun printHello(name: String?): Unit {
    if (name != null)
        println("Hello $name")
    else
        println("Hi there!")
    // `return Unit` or `return` is optional
} //The Unit return type declaration is also optional. The above code is equivalent to:
//fun printHello(name: String?) { ... }