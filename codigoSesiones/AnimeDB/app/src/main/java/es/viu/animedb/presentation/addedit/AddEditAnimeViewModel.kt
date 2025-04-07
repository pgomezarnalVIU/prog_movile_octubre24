package es.viu.animedb.presentation.addedit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import es.viu.animedb.presentation.AnimeVM

class AddEditAnimeViewModel : ViewModel(){
    private val _anime = mutableStateOf(AnimeVM())
    val anime: State<AnimeVM> = _anime

}