package es.viu.animedb.presentation.addedit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import es.viu.animedb.presentation.AnimeVM
import es.viu.animedb.presentation.addOrUpdateAnime
import es.viu.animedb.presentation.components.SortByCreador
import es.viu.animedb.presentation.getAnime
import es.viu.animedb.presentation.getAnimes

class AddEditAnimeViewModel(animeId:Int=-1) : ViewModel() {

    private val _anime = mutableStateOf(AnimeVM())
    val anime: State<AnimeVM> = _anime

    /*
    private fun findAnime(animeId: Int) {
        _anime.value = getAnimes(SortByCreador).find { it.id == animeId } ?: AnimeVM()
    }*/
    //Creamos una funcion findAnime
    private fun findAnime(animeId: Int){
        _anime.value = getAnime(animeId) ?: AnimeVM()
    }

    init {
        findAnime(animeId)
    }
    fun onEvent(event: AddEditAnimeEvent) {
        when (event) {
            is AddEditAnimeEvent.EnteredCreator -> {
                _anime.value = _anime.value.copy(creador = event.creator)
            }

            is AddEditAnimeEvent.EnteredTitle -> {
                _anime.value = _anime.value.copy(titulo = event.title)
            }

            AddEditAnimeEvent.AnimeView -> _anime.value = _anime.value.copy(vista = !_anime.value.vista)
            is AddEditAnimeEvent.TypeChanged -> {
                _anime.value = _anime.value.copy(animeType = event.bookType)
            }

            AddEditAnimeEvent.SaveAnime -> {
                //Se salva
                addOrUpdateAnime(_anime.value)
            }

        }
    }


}

