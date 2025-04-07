package es.viu.animedb.presentation.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.viu.animedb.R
import es.viu.animedb.presentation.components.AnimeCard
import es.viu.animedb.presentation.components.AnimeEvent
import es.viu.animedb.presentation.components.SortOptions

@Composable
fun ListAnimesScreen(animesViewModel: ListAnimesViewModel/*animes: List<AnimeVM>*/, innerPadding: PaddingValues){
    /*
    ESTO LO VA A GESTIONAR ANIMES VIEWMODEL
    var localAnimes by remember { mutableStateOf(animes) }
    var sortOrder: SortOrder by remember { mutableStateOf(SortByAuthor)}
    */

    /*SCAFFOLD PARA ENVOLVER LA VENTANA*/
    Scaffold (
        floatingActionButton = {
            FloatingActionButton( onClick = {
                println("Navegamos a la ventana de nuevo Anime")
            },
                modifier = Modifier.background(Color.Transparent),
                elevation = FloatingActionButtonDefaults.elevation(1.dp)
            )
            {
                Icon(imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.add))
            }
        }
    )
    {
        contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(horizontal = 8.dp)
                .fillMaxSize()
        )
        {
            /*TEXTO*/
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.cabecera),
                fontSize = 32.sp
            )
            /*FILTRADO*/
            SortOptions(animeOrder = animesViewModel.sortOrder.value,
                onSortOrderChange = {
                        order ->
                    animesViewModel.onEvent(AnimeEvent.Order(order))
                } )
            /*
            SortOptions(animeOrder = sortOrder, onSortOrderChange = {
                order ->
                sortOrder = order
                localAnimes = sortAnimes(localAnimes, AnimeEvent.Order(order))

            } )
             */
            /*LISTADO DE DATOS*/
            LazyColumn(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            )
            {
                items(animesViewModel.animes.value) { anime ->
                    AnimeCard(anime){
                        println("Borrado desde ListAnimes Screen ")
                        animesViewModel.onEvent(AnimeEvent.Delete(anime))
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
                /*
                localAnimes.forEach { anime ->
                    item {
                        AnimeCard(anime) {
                            println("Borrado desde ListAnimesScreen " + anime.title)
                            localAnimes = localAnimes.filter { it != anime }
                            //animes.remove(anime)
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }*/
            }
        }
    }

}