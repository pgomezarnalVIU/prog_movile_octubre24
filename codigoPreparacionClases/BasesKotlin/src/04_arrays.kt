
/**
An array is a data structure that holds a fixed number of values of the same type or its subtypes.
The most common type of array in Kotlin is the object-type array, represented by the Array class.*/

fun main(){

    // CREACIÓN DE ARRAYS
    /*
    * functions, such as arrayOf(), arrayOfNulls() or emptyArray().
    * */
    val nombres = arrayOf("Paco","Francisco","Pancho","Pepe")
    val arrayVacio = emptyArray<Int>()

    println("nombres[0]=${nombres[0]}")

    /*ARRAY ES INMUTABLE, no podemos añadir eliminar elementos*/
    /*El contenido del array es MUTABLE*/

    /*
    * The Array constructor
    * takes the array size and a function that returns values for array elements given its index:
    * */
    val simpleArray = Array<Int>(3) { 0 }
    println("simpleArray="+simpleArray.joinToString())
    /*
    * Arrays can be nested within each other to create multidimensional arrays:
    *
    * */

    val twoDArray = Array(2) { Array<Int>(2) { 0 } }
    println("twoDArray="+twoDArray.contentDeepToString())

    /*
    * Arrays are always mutable.
    * To access and modify elements in an array, use the indexed access operator[]
    *
    * */
    simpleArray[0] = 10
    twoDArray[0][0] = 2

    /*
    * . As an alternative, you can use primitive-type arrays,
    * which allow you to store primitives in an array without the side effect of boxing overhead:
    * https://kotlinlang.org/docs/arrays.html#primitive-type-arrays
    * */

    // Creates an array of Int of size 5 with the values initialized to zero
    val exampleArray = IntArray(5)
    println("exampleArray="+exampleArray.joinToString())
}