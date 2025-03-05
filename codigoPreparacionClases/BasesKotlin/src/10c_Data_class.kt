//https://kotlinlang.org/docs/data-classes.html

// Definición de la data class para representar un jugador
// Es lo que se denomina struct en otros lenguajes
// Se utilizan para almacenar datos
// No se pueden definir métodos
// Automáticamente tiene como métodos equals, toString, copy
data class Jugador(
    val nombre: String,
    val equipo: String,
    val posicion: String,
    val puntosPorPartido: Double
)

fun main() {
    // Creación de instancias de jugadores
    val jugador1 = Jugador("LeBron James", "Lakers", "Alero", 25.3)
    val jugador2 = Jugador("Stephen Curry", "Warriors", "Base", 27.1)
    val jugador3 = Jugador("Kevin Durant", "Nets", "Alero", 26.9)

    // Lista de jugadores
    val jugadores = listOf(jugador1, jugador2, jugador3)

    // Imprimir información de cada jugador
    jugadores.forEach { jugador ->
        println("Nombre: ${jugador.nombre}, Equipo: ${jugador.equipo}, Posición: ${jugador.posicion}, Puntos por partido: ${jugador.puntosPorPartido}")
    }
}