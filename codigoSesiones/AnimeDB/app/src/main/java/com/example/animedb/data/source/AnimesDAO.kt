package com.example.animedb.data.source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.animedb.domain.model.Anime
import kotlinx.coroutines.flow.Flow

//Calse Abstracta siguiendo el patrón DAO para la interaccion con la tabla Animes

@Dao
interface AnimesDAO {

    //Funciones interacción con la BBDD
    @Query("SELECT * FROM animes")
    fun getAnimes() : Flow<List<Anime>>
    @Query("SELECT * FROM animes WHERE id = :id")
    fun getAnime(id:Int) : Anime?

    //Update_Insert necesitan ser suspend_async
    //Delete también necesita ser suspend_async
    @Upsert
    fun upsertAnime(anime:Anime)
    @Delete
    fun deleteAnime(anime:Anime)
}