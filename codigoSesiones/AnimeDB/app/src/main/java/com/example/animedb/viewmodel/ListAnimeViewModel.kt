package com.example.animedb.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animedb.data.animes

import com.example.animedb.data.Anime
import com.example.animedb.data.getAnimes
import com.example.animedb.data.source.AnimesDAO
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ListAnimeViewModel(val dao:AnimesDAO) : ViewModel() {

    //Variable en memoria que almacene la información de la lista de libros
    private val _animes: MutableState<List<Anime>> = mutableStateOf(emptyList())
    //Variable pública que usaremos para comunicar los cambios observador al UI
    var animesVM: State<List<Anime>> = _animes

    //Creamos un job un thread para comprobar si los libros se han cargado de la BBDD
    var job: Job? = null

    init{
        //Si el job existe se cancela antes de cargar
        //Evitamos dobles cargas
        job?.cancel()

        //Cargamos los datos iniciales
        //Cambiamos para cargarlos desde ese flow
        //En vez de usar collect usaremos onEach, es más flexible y no es necesario utilizarlo dentro de una funcions suspend
        //pero necesitaremos lanzarlo como corrutina
        job=dao.getAnimes().onEach { animes ->
            //Necesitamos una transformación de modelo a datos
            //Mapearemos cada entity a un Anime
            _animes.value =animes.map{
                Anime.fromEntity(it)
            }
        }.launchIn(viewModelScope)

        //_animes.value = animes
    }

    fun onDeleteAnime(anime:Anime){
        _animes.value = _animes.value.filter { it != anime}
    }
}