package es.repositoriocompartido.nuevoproyecto

//https://kotlinlang.org/docs/enum-classes.html
enum class TipoPokemon {
    AGUA, ELECTRICO, FUEGO
}
enum class TipoAtaque {
    NORMAL, ELECTRICO, PSIQUICO, AGUA, LUCHA
}

class Ataque(val nombre:String,val tipoAtaque:TipoAtaque, val valor:Int)

class Pokemon(val nombre:String,val tipo:TipoPokemon,var vida:Int=0,val ataques:Array<Ataque>){
    fun restarVida(danyo:Int =0){
        this.vida-=danyo
    }
    fun pintarAtaques(){
        var i=0
        for(ataque in ataques){
            print("${ataque.nombre}[$i] ")
            i++
        }
        println()
    }
}

fun main(){
    var jugarPartida=true
    var turnoPikachu=true
    var ataqueElegido:String=""
    var ataqueRndmS:Int=0
    //Creamos Pikachu
    val ataquesPikachu=arrayOf(Ataque("Látigo",TipoAtaque.NORMAL,30),
        Ataque("BolaVoltio",TipoAtaque.ELECTRICO,10),
        Ataque("Agilidad",TipoAtaque.PSIQUICO,30)
    )
    val pikachu = Pokemon("Pikachu",TipoPokemon.ELECTRICO,100,ataquesPikachu)

    //Creamos Squirtle
    val ataquesSquirtle=arrayOf(Ataque("Sorpresa",TipoAtaque.NORMAL,40),
    Ataque("Demolicion",TipoAtaque.LUCHA,10),
        Ataque("Buceo",TipoAtaque.AGUA,20)
    )
    val squirtle = Pokemon("Squirtle",TipoPokemon.AGUA,100,ataquesSquirtle)

    println("==== COMIENZA LA PELEA ENTRE PIKACHU Y SQUIRTLE ====")
    println(" ${pikachu.nombre.uppercase()} : ${pikachu.vida}")
    println(" ${squirtle.nombre.uppercase()} : ${squirtle.vida}")

    while (jugarPartida){
        //Comprobar de quien es el turno
        if(turnoPikachu){
            println("## ATAQUE PIKACHU ")
            println("## ELIGE UN ATAQUE -> ")
            pikachu.pintarAtaques()
            ataqueElegido= readln()
            when (ataqueElegido.toInt()){
                0 -> squirtle.restarVida(pikachu.ataques[0].valor)
                1 -> squirtle.restarVida(pikachu.ataques[1].valor)
                2 -> squirtle.restarVida(pikachu.ataques[2].valor)
                else -> squirtle.restarVida(pikachu.ataques[1].valor)
            }
            turnoPikachu=false
        }else{
            println("## ATAQUE SQUIRTLE ")
            ataqueRndmS=(0..2).random()
            println("## SQUIRTLE ATACA CON -> ${squirtle.ataques[ataqueRndmS].nombre.uppercase()}")
            pikachu.restarVida(squirtle.ataques[ataqueRndmS].valor)
            turnoPikachu=true
        }
        if(squirtle.vida<=0 ||  pikachu.vida<=0) jugarPartida=false
        println()
        println(" ${pikachu.nombre.uppercase()} : ${pikachu.vida}")
        println(" ${squirtle.nombre.uppercase()} : ${squirtle.vida}")
    }

}
