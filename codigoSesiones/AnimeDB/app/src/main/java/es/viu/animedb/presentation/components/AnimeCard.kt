package es.viu.animedb.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.viu.animedb.presentation.AnimeVM
import es.viu.animedb.R

@Composable
fun AnimeCard(anime: AnimeVM, onDeleteClick: (AnimeVM)->Unit){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = anime.animeType.backgroundColor,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(8.dp)
    )
    {
        Column()
        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(anime.title,
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = anime.animeType.foregroundColor
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                if(anime.view){
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = stringResource(R.string.view)
                    )
                }
            }
            Text(anime.author,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = anime.animeType.foregroundColor
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
        IconButton(
            onClick = {
                onDeleteClick(anime)
            },
            modifier = Modifier.align (Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = stringResource(R.string.delete),
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }

}