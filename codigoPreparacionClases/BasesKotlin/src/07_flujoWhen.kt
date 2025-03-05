
fun main(){
    /*
    * when is a conditional expression that runs code based on multiple possible values or conditions.
    * */
    print("Introduce un numero: ")
    val x = readln().toInt()
    when (x) {
        1 -> println("x == 1")
        2 -> println("x == 2")
        else -> println("x is neither 1 nor 2")
    }

    /*
    * You can use when in a few different ways.
    * Firstly, you can use when either as an expression or as a statement.
    * As an expression, when returns a value for later use in your code.
    * As a statement, when completes an action without returning anything of further use:
    * */

    val text = when (x) {
        1 -> "x == 1"
        2 -> "x == 2"
        else -> "x is neither 1 nor 2"
    }
    println("When como expreseion= $text")

    /*
    * También se pueden incorporar expresiones en el when
    *
    * */
    print("Introduce un numero: ")
    var a= readln().toInt()
    print("Introduce un numero: ")
    var b= readln().toInt()

    val text2 = when {
        a > b -> "$a is greater than $b"
        a < b -> "$a  is less than $b"
        else -> "$a  is equal to $b"
    }
    println("El maximo es= $text2")

    /*
    * You can define a common behavior for multiple cases
    * by combining their conditions in a single line with a comma:
    * */

    when (x) {
        0, 1 -> println("x == 0 or x == 1")
        else -> println("otherwise")
    }

    /*
    * You can also check whether a value
    * is or isn't contained in a range or collection via the in or !in keywords:
    * */
    val validNumbers = arrayOf(1,4,7)

    when (x) {
        in 1..10 -> println("x is in the range")
        in validNumbers -> println("x is valid")
        !in 10..20 -> println("x is outside the range")
        else -> println("none of the above")
    }
}