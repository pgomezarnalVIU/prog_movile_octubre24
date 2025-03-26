package es.viu.animedb.presentation

import es.viu.animedb.R
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.viu.animedb.presentation.components.AnimeCard
import es.viu.animedb.presentation.components.AnimeEvent
import es.viu.animedb.presentation.components.SortByCreador
import es.viu.animedb.presentation.components.SortOptions
import es.viu.animedb.presentation.components.SortOrder
import java.time.format.TextStyle

@Composable
fun ListAnimesScreen(animes: List<AnimeVM>, innerPadding: PaddingValues) {

    var localAnimes by remember { mutableStateOf(animes) }

    var sortOrder: SortOrder by remember {
        mutableStateOf(SortByCreador)
    }

    Column(){
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.cabecera),
            fontSize = 16.sp
        )


        SortOptions(animeOrder = sortOrder, onSortOrderChange = { order ->
            sortOrder = order
            localAnimes = sortAnimes(localAnimes, AnimeEvent.Order(order))
        })

        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn  (modifier = Modifier
            .padding(innerPadding)
            .border(1.dp,color=Color.Blue)
            .fillMaxSize()
        )
        {
            /*
            Text("Hola")
            Text("Adios")
            */
            localAnimes.forEach { anime ->
                item{
                    AnimeCard(anime){
                        println("Borrando "+anime.titulo)
                        localAnimes = localAnimes.filter { it != anime }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }


}
