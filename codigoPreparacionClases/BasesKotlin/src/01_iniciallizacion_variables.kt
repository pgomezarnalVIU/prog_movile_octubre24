/*
    Primer fichero variables Kotlin
    https://kotlinlang.org/docs/basic-syntax.html#variables
 */
fun main() {
    /*
* In Kotlin, you declare a variable starting with a keyword, val or var,
* followed by the name of the variable.
*
* Use the val keyword to declare variables that are assigned a value only once. These are immutable,
* read-only local variables that can’t be reassigned a different value after initialization
*
*
* Use the var keyword to declare variables that can be reassigned.
* These are mutable variables, and you can change their values after initialization
* */

    // Declares the variable x and initializes it with the value of 5
    val x: Int = 5
    // Declares the variable x and initializes it with the value of 5
    var y: Int = 5
    // Reassigns a new value of 6 to the variable x
    y += 1

}