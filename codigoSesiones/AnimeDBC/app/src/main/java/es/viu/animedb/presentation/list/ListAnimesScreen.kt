package es.viu.animedb.presentation.list

import androidx.compose.foundation.background
import es.viu.animedb.R
import androidx.compose.foundation.layout.Column
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
import androidx.navigation.NavController
import es.viu.animedb.presentation.components.AnimeCard
import es.viu.animedb.presentation.components.AnimeEvent
import es.viu.animedb.presentation.components.SortOptions
import es.viu.animedb.presentation.utils.Screen

@Composable
fun ListAnimesScreen(navController : NavController, animesViewModel: ListAnimesViewModel) {

    /*
    var localAnimes by remember { mutableStateOf(animes) }

    var sortOrder: SortOrder by remember {
        mutableStateOf(SortByCreador)
    }*/

    Scaffold(
        floatingActionButton = {
            FloatingActionButton( onClick = {
                println("Navegamos a la ventana de nuevo Anime")
                navController.navigate(Screen.AddEditAnimeScreen.route)
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
    { contentPadding ->

        Column(modifier = Modifier.padding(contentPadding)) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.cabecera),
                fontSize = 32.sp
            )
            SortOptions(animeOrder = animesViewModel.sortOrder.value, onSortOrderChange = { order ->
                animesViewModel.onEvent(AnimeEvent.Order(order))
            })
            /*
            SortOptions(animeOrder = sortOrder, onSortOrderChange = { order ->
                sortOrder = order
                localAnimes = sortAnimes(localAnimes, AnimeEvent.Order(order))
            })
            */

            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn(
                modifier = Modifier
                    .padding(1.dp)
                    .fillMaxSize()
            )
            {
                /*
                Text("Hola")
                Text("Adios")
                */
                items(animesViewModel.animes.value) { anime ->
                    AnimeCard(navController,anime, onDeleteClick = {
                        println("Borrando " + anime.titulo)
                        animesViewModel.onEvent(AnimeEvent.Delete(anime))
                    })
                    Spacer(modifier = Modifier.height(2.dp))
                }
                /*
                localAnimes.forEach { anime ->
                    item{
                        AnimeCard(anime){
                            println("Borrando "+anime.titulo)
                            localAnimes = localAnimes.filter { it != anime }
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                    }
                }
                */
            }
        }
    }


}
