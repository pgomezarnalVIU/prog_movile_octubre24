package com.example.animedb.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animedb.data.Anime
import com.example.animedb.data.getAnime
import com.example.animedb.data.addOrUpdateAnime
import com.example.animedb.data.AnimeType
import com.example.animedb.data.animes
import com.example.animedb.data.source.AnimesDAO
import com.example.animedb.data.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class AddEditAnimeViewModel(val dao: AnimesDAO, animeId: Int = -1) : ViewModel() {

    //Variable en memoria que almacene la información de la lista de libros
    private val _anime = mutableStateOf(Anime())
    //Variable pública que usaremos para comunicar los cambios observador al UI
    var anime: State<Anime> = _anime

    init{
        //Recuperamos el anime mediante el dao DB
        //Por defecto el thred se lanza en el main de la aplicación
        viewModelScope.launch (Dispatchers.IO){
            val animeEntity = dao.getAnime(animeId)
            //Usamos la transformación de entity
            //Usamos ? porque puede ser un null
            _anime.value = animeEntity?.let {Anime.fromEntity(it)}?:Anime()
        }
        //_anime.value = getAnime(animeId)
    }


    fun addTitulo(titulo:String){
        _anime.value = _anime.value.copy(titulo=titulo)
    }

    fun addCreador(creador:String){
        _anime.value = _anime.value.copy(creador=creador)
    }

    fun visto(){
        _anime.value = _anime.value.copy(vista = !_anime.value.vista)
    }

    fun setType(type:AnimeType){
        _anime.value = _anime.value.copy(animeType = type)
    }


    fun addEditAnime(){
        //Hacemos el proceso contrario convertimos el Anime a Entity
        viewModelScope.launch (Dispatchers.IO){
            val entity =  anime.value.toEntity()
            dao.upsertAnime(entity)
        }
        //Old
        //addOrUpdateAnime(anime.value)
    }
}