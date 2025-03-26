package es.viu.animedb.presentation

import androidx.compose.ui.graphics.Color
import es.viu.animedb.ui.theme.Purple40
import es.viu.animedb.ui.theme.Purple80
import es.viu.animedb.ui.theme.PurpleGrey40
import es.viu.animedb.ui.theme.PurpleGrey80

//Definir el tipo de anime
sealed class AnimeType(val backgroundColor: Color,val foregroundColor: Color)
data object Fantasy:AnimeType(Purple80, PurpleGrey40)
data object SciFiction: AnimeType(Purple40, PurpleGrey80)

//Plantilla de datos
data class AnimeVM(
    val title:String="",
    val author:String="",
    val year:Int=2000,
    val view: Boolean=false,
    val animeType: AnimeType
)

//Lista de Animes
val animes: MutableList<AnimeVM> = mutableListOf(
    AnimeVM("Dragon Ball Z", "Akira Toriyama", 1989,true,Fantasy),
    AnimeVM("Naruto", "Masashi Kishimoto", 2002,false,Fantasy),
    AnimeVM("One Piece", "Eiichiro Oda", 1999,false,SciFiction),
    AnimeVM("Pokémon", "Satoshi Tajiri", 1997,true,Fantasy),
    AnimeVM("Attack on Titan", "Hajime Isayama", 2013,true,SciFiction),
    AnimeVM("Sailor Moon", "Naoko Takeuchi", 1992,false,Fantasy),
    AnimeVM("Death Note", "Tsugumi Ohba / Takeshi Obata", 2006,true,SciFiction),
    AnimeVM("Fullmetal Alchemist: Brotherhood", "Hiromu Arakawa", 2009,true,Fantasy),
    AnimeVM("Neon Genesis Evangelion", "Hideaki Anno", 1995,true,SciFiction),
    AnimeVM("Bleach", "Tite Kubo", 2004,true,SciFiction),
    AnimeVM("One Punch Man", "ONE (creador original)", 2015,true,SciFiction),
    AnimeVM("My Hero Academia", "Kōhei Horikoshi", 2016,true,SciFiction),
    AnimeVM("Demon Slayer: Kimetsu no Yaiba", "Koyoharu Gotouge", 2019,false,Fantasy),
    AnimeVM("Fairy Tail", "Hiro Mashima", 2009,true,SciFiction),
    AnimeVM("Cowboy Bebop", "Shinichirō Watanabe", 1998,false,SciFiction),
    AnimeVM("JoJo's Bizarre Adventure", "Hirohiko Araki", 2012,false,Fantasy),
    AnimeVM("Mobile Suit Gundam", "Yoshiyuki Tomino", 1979,false,Fantasy),
    AnimeVM("Yu Yu Hakusho", "Yoshihiro Togashi", 1992,false,Fantasy),
    AnimeVM("Detective Conan", "Gosho Aoyama", 1996,true,Fantasy),
    AnimeVM("Ranma ½", "Rumiko Takahashi", 1989,true,Fantasy)
)
