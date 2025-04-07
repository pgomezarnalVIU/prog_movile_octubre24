package com.example.animedb.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.animedb.data.AnimeType

//Esta clase reflejará nuestra tabla en BBDD llamada Animes
// Normalmente las tablas se definen en plural pero los Entities en singular
@Entity (tableName = "animes")
data class Anime(
    //El id será nulo ya que la BBDD será quien lo genere
    @PrimaryKey(autoGenerate = true) val id:Int?=null,
    val titulo:String,
    val creador:String,
    val año:Int,
    val vista:Boolean,
    val animeType: AnimeType
)