
package com.example.animedb.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.animedb.R
import com.example.animedb.data.Anime


@Composable
fun AnimeCard(navController:NavController,anime:Anime, onDeleteClick: (Anime)-> Unit){
    Box(modifier = Modifier
        /*.border(width = 1.dp, color = Color.Red)*/
        .padding(16.dp)
        .background(color=anime.animeType.backgroundColor, shape = RoundedCornerShape(10.dp))
        .fillMaxSize()
        .clickable {
            //Permite seleccionar el card para editar el anime
            //Necesitamos el navcontroller
            navController.navigate(Screen.AddEditAnimeScreen.ruta+"?animeId=${anime.id}")
        }
    ){
        Column{
            /*Valor del título*/
            var titulo: String by remember { mutableStateOf(anime.titulo) }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                /*Título del anime*/
                Text(titulo,
                    style = TextStyle(
                        fontSize = 32.sp,
                        color=anime.animeType.foregroundColor
                    ), maxLines = 1, overflow = TextOverflow.Ellipsis
                )
                /*Marcado como visto segun el boolean*/
                if(anime.vista) Icon(imageVector = Icons.Filled.Check,
                        contentDescription = stringResource(id= R.string.vista)
                       )
            }
            OutlinedTextField(
                value = titulo,
                textStyle =TextStyle(
                    fontSize = 32.sp,
                    color=anime.animeType.foregroundColor),
                maxLines = 1,
                onValueChange = {titulo = it}
            )
            /*Creador del anime*/
            Text(anime.creador,
                style = TextStyle(
                    fontSize = 32.sp,
                    color=Color.Gray), maxLines = 2, overflow = TextOverflow.Ellipsis
            )
        }
        /*Boton de borrado de libro*/
        IconButton(
            onClick = {onDeleteClick(anime)},
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete",
                tint = Color.White
            )
        }
    }
}