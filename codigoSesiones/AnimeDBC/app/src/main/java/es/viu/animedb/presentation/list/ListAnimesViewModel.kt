package es.viu.animedb.presentation.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.viu.animedb.presentation.AnimeVM
import es.viu.animedb.presentation.components.AnimeEvent
import es.viu.animedb.presentation.components.SortByCreador
import es.viu.animedb.presentation.components.SortOrder
import es.viu.animedb.presentation.getAnimes
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ListAnimesViewModel : ViewModel() {
    private val _animes: MutableState<List<AnimeVM>> = mutableStateOf(emptyList())
    var animes : State <List<AnimeVM>> = _animes

    private val _sortOrder : MutableState<SortOrder> = mutableStateOf(SortByCreador)
    var sortOrder : State <SortOrder> = _sortOrder

    init {
        loadAnimes (sortOrder.value)
    }

    fun loadAnimes(sortOrder: SortOrder){
        //Aquí haremos la llamada a la carga de datos
        //La carga de datos ahora está emitida
        //Queremos cargarla en _animes
        //Usaremos la carga uno a uno de los datos recibidos con onEach
        //Por ultimo usaremos el builder launchIn y el Scope viewModelScope
        getAnimes(sortOrder).onEach {
            animes ->
            _animes.value = animes
        }.launchIn(viewModelScope)
    }



    fun onEvent(event: AnimeEvent){
        when(event){
            is AnimeEvent.Delete -> {deleteAnime(event.anime)}
            is AnimeEvent.Order -> {
                _sortOrder.value = event.order
                loadAnimes(event.order)
            }
            else -> {
                loadAnimes(SortByCreador)
            }
        }
    }

    fun deleteAnime(anime: AnimeVM){
        _animes.value = _animes.value.filter { it != anime }
    }
}