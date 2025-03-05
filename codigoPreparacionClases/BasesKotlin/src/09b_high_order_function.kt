// https://kotlinlang.org/docs/lambdas.html

// Función de orden superior que recibe otra función como parámetro
/* En este ejemplo, la función aplicarOperacion es una high-order function porque recibe como parámetro
   otra función (Int, Int) -> Int.
   Esto permite que puedas pasar distintas operaciones (suma, resta, multiplicación, etc.)
   sin necesidad de definir múltiples funciones.
 */
fun aplicarOperacion(a: Int, b: Int, operacion: (Int, Int) -> Int): Int {
    return operacion(a, b)
}

fun main() {
    // Función lambda que suma dos números
    // Al usar {} estamos instanciando la función lambda. Se denomina code block
    // Sería la forma reducida de escribir la función anónima
    // fun(x:Int,y:Int):Int{return x+y}
    val suma = { x: Int, y: Int -> x + y }

    // Lambda que multiplica dos números
    val multiplicacion = { x: Int, y: Int -> x * y }

    // Usamos la función de orden superior para aplicar la suma
    val resultado = aplicarOperacion(5, 3, suma)
    println("El resultado de la suma es: $resultado")

    // Uso de la función de orden superior para aplicar la multiplicación
    val resultadoMultiplicacion = aplicarOperacion(5, 3, multiplicacion)
    println("El resultado de la multiplicación es: $resultadoMultiplicacion")
}