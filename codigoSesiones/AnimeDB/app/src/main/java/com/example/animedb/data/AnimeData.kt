package com.example.animedb.data

import androidx.compose.ui.graphics.Color
import com.example.animedb.ui.theme.Purple40
import com.example.animedb.ui.theme.Purple80
import com.example.animedb.ui.theme.PurpleGrey40
import com.example.animedb.ui.theme.PurpleGrey80
import kotlinx.coroutines.flow.flow

enum class AnimeType (val backgroundColor:Color, val foregroundColor:Color){
    FANTASIA(Purple80, PurpleGrey40),
    DEPORTES(Purple40, PurpleGrey80),
    CIENCIAFICC(Color.White,Color.DarkGray)
}

data class Anime(
    val id:Int=0,
    val titulo:String="",
    val creador:String="",
    val año:Int=0,
    val vista:Boolean=false,
    val animeType: AnimeType=AnimeType.FANTASIA
){
    companion object{
        fun fromEntity(entity:com.example.animedb.domain.model.Anime): Anime{
            return Anime(
                id=entity.id!!,
                titulo = entity.titulo,
                creador = entity.creador,
                año = entity.año,
                vista = entity.vista,
                animeType = entity.animeType
            )
        }
    }
}

fun Anime.toEntity(): com.example.animedb.domain.model.Anime{
    val id= if(this.id==-1) null else this.id
    return com.example.animedb.domain.model.Anime(
        id=id,
        titulo = this.titulo,
        creador = this.creador,
        año = this.año,
        vista = this.vista,
        animeType = this.animeType
    )
}

//Estos datos deberían alcanzarse desde un ApiRestFul
//Ahora se puede modificar la lista
val animes = mutableListOf(
    Anime(1,"Ataque a los Titanes","Hajime Isayama",2009,true,AnimeType.FANTASIA),
    Anime(2,"Haikyū!!","Haruichi Furudate",2012,true,AnimeType.DEPORTES ),
    Anime(3,"Bola de dragon","Akira Toriyama",1986, animeType = AnimeType.CIENCIAFICC),
    Anime(4,"Cyberpunk: Edgerunners","Rafał Jaki",2022,true, animeType = AnimeType.CIENCIAFICC),
    Anime(5,"Ataque a los Titanes","Hajime Isayama",2009,true,AnimeType.FANTASIA),
    Anime(6,"Haikyū!!","Haruichi Furudate",2012,true,AnimeType.DEPORTES ),
    Anime(7,"Bola de dragon","Akira Toriyama",1986, animeType = AnimeType.CIENCIAFICC),
    Anime(8,"Cyberpunk: Edgerunners","Rafał Jaki",2022,true, animeType = AnimeType.CIENCIAFICC),
    Anime(9,"Ataque a los Titanes","Hajime Isayama",2009,true,AnimeType.FANTASIA),
    Anime(10,"Haikyū!!","Haruichi Furudate",2012,true,AnimeType.DEPORTES ),
    Anime(11,"Bola de dragon","Akira Toriyama",1986, animeType = AnimeType.CIENCIAFICC),
    Anime(12,"Cyberpunk: Edgerunners","Rafał Jaki",2022,true, animeType = AnimeType.CIENCIAFICC),
    Anime(13,"Ataque a los Titanes","Hajime Isayama",2009,true,AnimeType.FANTASIA),
    Anime(14,"Haikyū!!","Haruichi Furudate",2012,true,AnimeType.DEPORTES ),
    Anime(15,"Bola de dragon","Akira Toriyama",1986, animeType = AnimeType.CIENCIAFICC),
    Anime(16,"Cyberpunk: Edgerunners","Rafał Jaki",2022,true, animeType = AnimeType.CIENCIAFICC),
    Anime(17,"Ataque a los Titanes","Hajime Isayama",2009,true,AnimeType.FANTASIA),
    Anime(18,"Haikyū!!","Haruichi Furudate",2012,true,AnimeType.DEPORTES ),
    Anime(19,"Bola de dragon","Akira Toriyama",1986, animeType = AnimeType.CIENCIAFICC),
    Anime(20,"Cyberpunk: Edgerunners","Rafał Jaki",2022,true, animeType = AnimeType.CIENCIAFICC),
)

//Funcion que busca un anime por su id, si no lo encuentra devuelve un nuevo anime
fun getAnime(animeId: Int): Anime {
    return animes.find { it.id == animeId } ?: Anime()
}

//Funcion que simula un flow de datos
fun getAnimes() = flow {
    emit(animes)
}

//Funcion que salva o edita un Anime
fun addOrUpdateAnime(anime: Anime) {
    val animeExiste = animes.find { it.id == anime.id }

    animeExiste?.let {
        animes.remove(it)
    }
    animes.add(anime)

}