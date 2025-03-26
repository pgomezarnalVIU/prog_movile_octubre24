package es.viu.animedb.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import es.viu.animedb.presentation.components.AnimeCard

@Composable
fun ListAnimesScreen(animes: List<AnimeVM>, innerPadding: PaddingValues){
    var localAnimes by remember { mutableStateOf(animes) }
    LazyColumn (
        modifier =  Modifier
            .padding(innerPadding)
            .border(2.dp,color=Color.Blue)
            .fillMaxSize()
    )
    {
        localAnimes.forEach { anime ->
            item{
                AnimeCard(anime){
                    println("Borrado desde ListAnimesScreen "+anime.title)
                    localAnimes = localAnimes.filter { it != anime }
                    //animes.remove(anime)
            }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}