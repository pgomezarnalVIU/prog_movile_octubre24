

fun main() {
    // OPERADOR ?
    // Permite asignar un nulo a una variable
    // Assigns a nullable string to a variable
    var b: String? = "abc"
    // Successfully re-assigns null to the nullable variable
    b = null
    println("El valor de b es $b") // null


    /*
    * CHECK SI ES NULO
    *
    * When working with nullable types, you need to handle nullability safely to avoid an NPE.
    * One way to handle this is checking for nullability explicitly with the if conditional
    * expression.
    * */

    // Assigns null to a nullable variable
    var c: String? = null
    // Checks for nullability first and then accesses length
    val x = if (c != null) c.length else -1
    println("El valor de c es $c") // null


    /*
    * SAFE OPERATOR
    * ?.
    *
    * The safe call operator ?. allows you to handle nullability safely in a shorter form.
    * Instead of throwing an NPE, if the object is null, the ?. operator simply returns null:
    * */

    // Assigns a nullable string to a variable
    val d: String? = "Kotlin"
    // Assigns null to a nullable variable
    val e: String? = null

    // Checks for nullability and returns length or null
    println("La longitud de d es ${d?.length}") // 6
    println("La longitud de e es ${e?.length}") // null


    /*
    * ELVIS OPERATOR
    * ?:
    *
    * When working with nullable types, you can check for null and provide an alternative value.
    * For example, if b is not null, access b.length. Otherwise, return an alternative value:
    * */

    // Assigns null to a nullable variable
    val f: String? = null
    // Checks for nullability. If not null, returns length. If null, returns 0
    // val y: Int = if (f != null) f.length else 0
    val y = f?.length ?: 0
    println("El valor de la longitud de y es $y")
    // 0

    /*
    * Not-null assertion operator
    * !!
    *
    * When you apply the !! operator to a variable whose value is not null,
    * it's safely handled as a non-nullable type, and the code executes normally.
    * However, if the value is null, the !! operator forces it to be treated as non-nullable,
    * which results in an NPE.
    * */

    // Assigns a nullable string to a variable
    val g: String? = "Kotlin"
    // Treats b as non-null and accesses its length
    val z = g!!.length
    println(z) // 6
    /*
    * Assigns null to a nullable variable
val b: String? = null
// Treats b as non-null and tries to access its length
val l = b!!.length
println(l) // Exception in thread "main" java.lang.NullPointerException
    *
    *
    *
    * The !! operator is particularly useful when you are confident that a value is not null
    * and there’s no chance of getting an NPE,
    * but the compiler cannot guarantee this due to certain rules.
    * In such cases, you can use the !! operator to explicitly tell the compiler that the value
    * is not null.
    * */
}