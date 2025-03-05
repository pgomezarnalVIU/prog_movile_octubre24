/*
    Segundo fichero variables Kotlin
    https://kotlinlang.org/docs/basic-types.html
 */
fun main() {
    //Kotlin supports type inference
    //and automatically identifies the data type of a declared variable
    //INTEGER
    /*
    * When you initialize a variable with no explicit type specification,
    * the compiler automatically infers the type with the smallest range
    * enough to represent the value starting from Int.
    * If it doesn't exceed the range of Int, the type is Int.
    * If it does exceed that range, the type is Long.
    * To specify the Long value explicitly, append the suffix L to the value.
    * To use the Byte or Short type, specify it explicitly in the declaration.
    * */
    val one = 1 // Int
    val edad:Int = 48
    println("one $one")
    println("edad $edad")
    // daría error val:Int = "Paco"
    val threeBillion = 3000000000 // Long
    println("threeBillion $threeBillion")
    val oneLong = 1L // Long
    val oneByte: Byte = 1

    //DECIMALES
    /*
    * You can initialize Double and Float variables only with numbers that have a fractional part.
    * Separate the fractional part from the integer part by a period (.)
    *
    * To explicitly specify the Float type for a value, add the suffix f or F
    * */
    val pi = 3.14 // Double
    println("pi $pi")
    //val one: Double = 1 // Error: type mismatch
    val oneDouble = 1.0 // Double
    val e = 2.7182818284 // Double
    val eFloat = 2.7182818284f // Float, actual value is 2.7182817

    //CARACT Y STRING
    /*
    * Characters are represented by the type Char.
    *
    * Strings in Kotlin are represented by the type String
    * Generally, a string value is a sequence of characters in double quotes (")
    * */
    val aChar: Char = 'a'
    val str = "Esto es una frase completa" //Automáticamente se detecta que es un string
    val str2:String = "Esto es una frase completa" //ES UNA BUENA PRÁCTICA

    //BOOLEANOS O LOGICOS
    /*
    *
    * The type Boolean represents boolean objects that can have two values: true and false
    * */
    val myTrue: Boolean = true
    println("myTrue $myTrue")
    val myFalse: Boolean = false


}