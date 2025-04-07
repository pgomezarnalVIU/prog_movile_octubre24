package es.viu.animedb.presentation

import androidx.compose.ui.graphics.Color
import es.viu.animedb.presentation.components.AnimeEvent
import es.viu.animedb.presentation.components.SortByCreador
import es.viu.animedb.presentation.components.SortByFiccion
import es.viu.animedb.presentation.components.SortByTitulo
import es.viu.animedb.presentation.components.SortByVisto
import es.viu.animedb.presentation.components.SortOrder
import es.viu.animedb.ui.theme.Purple40
import es.viu.animedb.ui.theme.Purple80
import es.viu.animedb.ui.theme.PurpleGrey40
import es.viu.animedb.ui.theme.PurpleGrey80
import kotlinx.coroutines.flow.flow

/*
enum class AnimeType {
    NORTH, SOUTH, EAST, WEST
}
*/
sealed class AnimeType(val backgroundColor:Color, val foregroundColor:Color, val borderColor:Color)
data object Fantasy:AnimeType(Purple80, PurpleGrey40, Purple40)
data object SciFiction:AnimeType(Purple40, PurpleGrey80, Purple80)

//Data class, clase usada en Kotlin para definir datos
data class AnimeVM(
    val id:Int=0,
    val titulo:String="",
    val creador:String="",
    val año:Int=0,
    val vista:Boolean=false,
    val animeType: AnimeType = Fantasy
)


//Lista de animes para cargar en la screen
private val animesList: MutableList<AnimeVM> = mutableListOf(
    AnimeVM(1,"Dragon Ball Z", "Akira Toriyama", 1989,true,Fantasy),
    AnimeVM(2,"Naruto", "Masashi Kishimoto", 2002,false,Fantasy),
    AnimeVM(3,"One Piece", "Eiichiro Oda", 1999,false,SciFiction),
    AnimeVM(4,"Pokémon", "Satoshi Tajiri", 1997,true,Fantasy),
    AnimeVM(5,"Attack on Titan", "Hajime Isayama", 2013,true,SciFiction),
    AnimeVM(6,"Sailor Moon", "Naoko Takeuchi", 1992,false,Fantasy),
    AnimeVM(7,"Death Note", "Tsugumi Ohba / Takeshi Obata", 2006,true,SciFiction),
    AnimeVM(8,"Fullmetal Alchemist: Brotherhood", "Hiromu Arakawa", 2009,true,Fantasy),
    AnimeVM(9,"Neon Genesis Evangelion", "Hideaki Anno", 1995,true,SciFiction),
    AnimeVM(10,"Bleach", "Tite Kubo", 2004,true,SciFiction),
    AnimeVM(11,"One Punch Man", "ONE (creador original)", 2015,true,SciFiction),
    AnimeVM(12,"My Hero Academia", "Kōhei Horikoshi", 2016,true,SciFiction),
    AnimeVM(13,"Demon Slayer: Kimetsu no Yaiba", "Koyoharu Gotouge", 2019,false,Fantasy),
    AnimeVM(14,"Fairy Tail", "Hiro Mashima", 2009,true,SciFiction),
    AnimeVM(15,"Cowboy Bebop", "Shinichirō Watanabe", 1998,false,SciFiction),
    AnimeVM(16,"JoJo's Bizarre Adventure", "Hirohiko Araki", 2012,false,Fantasy),
    AnimeVM(17,"Mobile Suit Gundam", "Yoshiyuki Tomino", 1979,false,Fantasy),
    AnimeVM(18,"Yu Yu Hakusho", "Yoshihiro Togashi", 1992,false,Fantasy),
    AnimeVM(19,"Detective Conan", "Gosho Aoyama", 1996,true,Fantasy),
    AnimeVM(20,"Ranma ½", "Rumiko Takahashi", 1989,true,Fantasy)
)


fun sortAnimes(animes: List<AnimeVM>, event: AnimeEvent.Order): List<AnimeVM> {
    return when(event.order) {
        SortByCreador -> animes.sortedBy { it.creador }
        SortByFiccion -> animes.sortedBy { it.animeType == SciFiction }
        SortByVisto -> animes.sortedBy { it.vista }
        SortByTitulo -> animes.sortedBy { it.titulo }
    }
}


//Implementamos la emisión de datos para simular una fuente
fun getAnimes(orderBy: SortOrder) = flow{
    emit(when(orderBy) {
        SortByCreador -> animesList.sortedBy { it.creador }
        SortByFiccion -> animesList.sortedBy { it.animeType == SciFiction }
        SortByVisto -> animesList.sortedBy { it.vista }
        SortByTitulo -> animesList.sortedBy { it.titulo }
        else -> animesList.sortedBy { it.creador }
    })
}

//Funcion que devuelve el Anime para un id
fun getAnime(animeId: Int): AnimeVM?{
    return animesList.find {it.id == animeId}
}

fun addOrUpdateAnime(anime: AnimeVM){
    animesList.add(anime)
}