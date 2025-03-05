
fun main(){

    // TIPOS DE STRINGS
    /*
     * Kotlin has two types of string literals:
     * Escaped strings
     * Multiline strings
    * */
    val s = "Hello, world!\n" //escaped string
    println(s)
    /*
    * Multiline strings can contain newlines and arbitrary text. It is delimited by a triple quote ("""),
    * contains no escaping and can contain newlines and any other characters:
    * */
    val text = """
    for (c in "foo")
        print(c)
    """
    println(text)

    /*
    * String literals may contain template expressions – pieces of code that are evaluated and whose results are concatenated into a string.
    * When a template expression is processed, Kotlin automatically calls the .toString() function on the expression's result to convert it into a string.
    * A template expression starts with a dollar sign ($) and consists of either a variable name:
    *
    *
    * */
    val i = 10
    println("i = $i")

    val letters = listOf("a","b","c","d","e")
    println("Letters: $letters")

    //or an expression in curly braces:
    val s2 = "abc"
    println("$s2.length is ${s2.length}")

}