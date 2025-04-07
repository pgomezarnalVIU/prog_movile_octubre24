package es.viu.animedb.presentation.components

import androidx.compose.foundation.background
import es.viu.animedb.R
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import es.viu.animedb.presentation.AnimeVM
import es.viu.animedb.presentation.utils.Screen
import java.nio.file.WatchEvent

@Composable
fun AnimeCard(navController : NavController,anime: AnimeVM, onDeleteClick: (AnimeVM)->Unit) {
    Box( modifier = Modifier
        .clickable {
            // Acción a realizar cuando se hace clic en cualquier parte del Box
            println("Hago click en el AnimeCard")
            navController.navigate(Screen.AddEditAnimeScreen.route+"?animeId=${anime.id}")
        }
        .border(
            width = 5.dp,
            color = anime.animeType.borderColor,
            shape = RoundedCornerShape(10.dp))
        .background(
            color=anime.animeType.backgroundColor
            , shape = RoundedCornerShape(10.dp)
        )
        .padding(16.dp)
        .fillMaxSize()

    ){
        /*COLUMN INFO DEL ANIME*/
        Column () {
            /*TITULO DEL ANIME*/
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {

                Text(anime.titulo,
                    style = TextStyle (fontSize = 32.sp,
                        color = anime.animeType.foregroundColor),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                if(anime.vista){
                    Icon(imageVector = Icons.Filled.Check,
                        contentDescription = stringResource(id=R.string.vista)
                    )
                }
            }
            /*TITULO DEL ANIME*/

            /*AUTOR DEL ANIME*/
            Text(anime.creador,
                style = TextStyle (fontSize = 32.sp,
                    color = anime.animeType.foregroundColor),
                maxLines = 10,
                overflow = TextOverflow.Ellipsis)
            /*AUTOR DEL ANIME*/
        }
        /*COLUMN INFO DEL ANIME*/
        IconButton(
            onClick = {
                //println("Borrando el anime")
                onDeleteClick(anime)},
            modifier = Modifier.align (Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = stringResource(id=R.string.delete),
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }
    }



}