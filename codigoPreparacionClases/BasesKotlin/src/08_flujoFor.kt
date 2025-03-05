
fun main(){
    /*
    * The for loop iterates through anything that provides an iterator.
    * for (item in collection) print(item)
    * */
    for (i in 1..3) {
        print(i)
    }
    println()
    for (i in 6 downTo 0 step 2) {
        print(i)
    }

    /*
    * Elements of a string are characters that you can access via the indexing operation: s[i].
    * You can iterate over these characters with a for loop:
    * */
    println()
    val str = "abcd 123"
    for (c in str) {
        print("$c,")
    }

    //Los arrays tiened una funcion forEach, aunque se puede usar for
    println()
    var riversArray = arrayOf("Nile", "Amazon", "Yangtze")
    for (river in riversArray) {
        println(river)
    }
    //If you want to iterate through an array or a list with an index, you can do it this way
    println()
    for (riverIndex in riversArray.indices) {
        print(riverIndex)
    }
    //Alternatively, you can use the withIndex library function:
    println()
    for ((index, value) in riversArray.withIndex()) {
        println("the element at $index is $value")
    }

    /*
    * while and do-while loops process their body continuously while their condition is satisfied.
    * The difference between them is the condition checking time:
    * */
    var x=10
    while (x > 0) {
        print("$x,")
        x--
    }
}