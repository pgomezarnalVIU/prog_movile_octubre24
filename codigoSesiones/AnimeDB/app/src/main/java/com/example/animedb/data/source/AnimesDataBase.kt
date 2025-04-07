package com.example.animedb.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.animedb.domain.model.Anime

//Relacionamos la BBDD con la definición de nuestro Entity
@Database(entities = [Anime::class], version = 1)
abstract class AnimesDataBase :RoomDatabase(){

    //DEfinicion del abstract DAO
    abstract val dao:AnimesDAO

    //Definición de la BBDD física
    companion object{
        const val DATABASE_NAME = "animes.db"
    }
}