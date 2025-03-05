/*
*Classes in Kotlin are declared using the keyword class:
*/
class Car { /*...*/ }

//Puede ser interesante crear clases vacias sobre cuando se definen plantillas
class Empty

/*
* Primary constructor parameters can be used in the initializer blocks.
* They can also be used in property initializers declared in the class body:
* */

class Customer(name: String) {
    val customerKey = name.uppercase()
}

/*
* Kotlin has a concise syntax for declaring properties and initializing them from the primary constructor
* Such declarations can also include default values of the class properties
 */

class Person(val firstName: String, val lastName: String, var isEmployed: Boolean = true){
 //properties declared in the primary constructor can be mutable (var) or read-only (val).
}