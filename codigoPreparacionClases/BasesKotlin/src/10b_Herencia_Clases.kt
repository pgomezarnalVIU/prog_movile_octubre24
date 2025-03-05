//https://kotlinlang.org/docs/inheritance.html

// Clase base (padre)
// se declara como open para permitir que otras clases hereden de ella.
// si no se declara como open, las clases se consideran finales
open class Personaje(val nombre: String) {
    open fun accion() {
        println("$nombre realiza una acción.")
    }
}

// Clase hija para héroes
class Heroe(nombre: String, val poder: String) : Personaje(nombre) {
    // Sobrescribimos la función para definir el comportamiento del héroe
    override fun accion() {
        println("$nombre, el héroe, usa su poder de $poder para salvar a la humanidad!")
    }
}

// Clase hija para villanos
class Villano(nombre: String, val maldad: String) : Personaje(nombre) {
    // Sobrescribimos la función para definir el comportamiento del villano
    override fun accion() {
        println("$nombre, el villano, ejecuta su plan de $maldad.")
    }
}

fun main() {
    val heroe = Heroe("Superman", "superfuerza")
    heroe.accion()  // Salida: Superman, el héroe, usa su poder de superfuerza para salvar a la humanidad!

    val villano = Villano("Lex Luthor", "dominar el mundo")
    villano.accion()  // Salida: Lex Luthor, el villano, ejecuta su plan de dominar el mundo.
}