package es.viu.animedb.presentation.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import es.viu.animedb.presentation.AnimeVM
import es.viu.animedb.presentation.components.AnimeEvent
import es.viu.animedb.presentation.components.SortOrder
import es.viu.animedb.presentation.components.SortByAuthor
import es.viu.animedb.presentation.getAnimes

class ListAnimesViewModel : ViewModel() {
    private val _animes: MutableState<List<AnimeVM>> = mutableStateOf(emptyList())
    var animes : State<List<AnimeVM>> = _animes

    private val _sortOrder : MutableState<SortOrder> = mutableStateOf(SortByAuthor)
    var sortOrder : State <SortOrder> = _sortOrder

    init{
        _animes.value = loadAnimes(sortOrder.value)
    }

    fun loadAnimes(sortOrder: SortOrder): List<AnimeVM>{
        //Aqui hacemos la carga de datos
        return getAnimes(sortOrder)
    }

    fun onEvent(event: AnimeEvent){
        when(event){
            is AnimeEvent.Delete -> {deleteAnime(event.anime)}
            is AnimeEvent.Order -> {
                _sortOrder.value = event.order
                _animes.value = loadAnimes(event.order)
            }
            else -> {
                _animes.value = loadAnimes(SortByAuthor)
            }
        }
    }

    fun deleteAnime(anime: AnimeVM){
        _animes.value  = _animes.value .filter { it != anime }
    }
 }