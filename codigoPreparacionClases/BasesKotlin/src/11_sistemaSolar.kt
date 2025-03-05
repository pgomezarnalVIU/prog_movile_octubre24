class PlanetaVacio //Clase totalmente legal sin constructor ni métodos ni propiedadas
class Planeta(val nombre:String,var diametro:Int) //Planeta con una propiedad read-only
{
    //Se pueden definir otras propiedades visibles dentro de la clase
    //En este caso no se inicializan a través del constructor principal
    var radio:Int
        get() = diametro/2 //El getter usa la sintaxis get()= ...
        /*
        *If you define a custom setter, it will be called every time you assign a value to the property,
        * except its initialization.
        * By convention, the name of the setter parameter is value, but you can choose a different name if you prefer.
        */
        set(valor)
            {
                if (valor<0) radio = this.diametro/2
                else {
                    radio = valor
                    this.diametro=radio*2
                }
            }
    //Podemos definir otras propiedades
    var poblacion:Long = 0
    var esGaseoso:Boolean= false

    /*A class can also declare secondary constructors, which are prefixed with constructor:*/
    /*
    *If the class has a primary constructor, each secondary constructor needs to delegate to the primary constructor,
    * either directly or indirectly through another secondary constructor(s).
    * */
    constructor(nombre:String,diametro:Int,esGaseoso:Boolean):this(nombre,diametro) //Segundo constructor
    constructor(nombre:String,diametro:Int,esGaseoso:Boolean,tieneVida:Boolean):this(nombre,diametro) //Tercer constructor

    /*
    * Code in initializer blocks effectively becomes part of the primary constructor.
    * */
    init{
        println("El planeta $nombre se ha creado") //Este código se ejecuta después de la asignación de valores a las propiedades
    }

}

fun main(){
    println("Cargando sistema solar...")
    //Nueva instancia de planeta vacio
    val planetaDesconocido=PlanetaVacio()
    //Nueva instancia de planeta Marte
    val marte=Planeta("Marte",6779)
    println("El planeta marte tiene un radio de ${marte.radio}")
    val tierra=Planeta("Tierra",12742,false,true)
    tierra.poblacion=7_000_0000

    println("Nuestro primer planeta desconocido $planetaDesconocido")
    println("Nuestro primer planeta ${tierra.nombre} con poblacion ${tierra.poblacion} ")
}