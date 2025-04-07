package es.viu.animedb.presentation.addedit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import es.viu.animedb.R
import es.viu.animedb.presentation.Fantasy
import es.viu.animedb.presentation.SciFiction
import es.viu.animedb.presentation.components.HorizontalTextRadioButton


@Composable
fun AddEditAnimeScreen(viewModel: AddEditAnimeViewModel) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    println("Creacion de un nuevo Anime")
                },
                modifier = Modifier.background(Color.Transparent),
                elevation = FloatingActionButtonDefaults.elevation(1.dp),
            )
            {
                Icon(imageVector = Icons.Default.Check,
                    contentDescription = stringResource(id = R.string.save))
            }
        }
    ){ contentPadding ->
        val anime = viewModel.anime.value
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .background(color = anime.animeType.backgroundColor)
        ) {
            Text(
                style = MaterialTheme.typography.headlineLarge,
                text = stringResource(id = R.string.add),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            )
            OutlinedTextField(
                value = anime.author,
                label = { Text("Creador") },
                onValueChange = {
                    //Evento modificacion de Anime
                },
                singleLine = true,
                textStyle = MaterialTheme.typography.headlineMedium.copy(color = anime.animeType.foregroundColor),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = anime.title,
                label = { Text("Título") },
                onValueChange = {
                    //Evento modificacion de Anime
                },
                singleLine = true,
                textStyle = MaterialTheme.typography.headlineMedium.copy(color = anime.animeType.foregroundColor),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Vista",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.headlineMedium.copy(color = anime.animeType.foregroundColor),
                )
                Checkbox(
                    checked = anime.view,
                    onCheckedChange = {
                        //Evento modificacion de Anime
                    }
                )
            }
            Row(modifier = Modifier.fillMaxWidth()) {

                HorizontalTextRadioButton(
                    selected = anime.animeType::class == Fantasy::class,
                    text = "Fantasy",
                    color = anime.animeType.foregroundColor,
                    onOptionSelected = {
                        //Evento modificacion de Anime
                    })
                HorizontalTextRadioButton(
                    selected = anime.animeType::class == SciFiction::class,
                    text = "SciFiction",
                    color = anime.animeType.foregroundColor,
                    onOptionSelected = {
                        //Evento modificacion de Anime
                    })
            }
        }

    }
}
