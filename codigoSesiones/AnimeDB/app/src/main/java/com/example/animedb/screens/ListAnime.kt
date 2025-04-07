package com.example.animedb.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.animedb.viewmodel.ListAnimeViewModel
import kotlinx.coroutines.launch


@Composable
fun ListAnime(navController:NavController,animesViewModel:ListAnimeViewModel) {

    //Necesitamos controlar el estado del snackbar para su repintado
    val snackbarHostState = remember { SnackbarHostState() }
    //Creamos un scope dentro del composable
    val scope = rememberCoroutineScope()

    //Layout para añadir elementos en la ventana
    Scaffold (
        modifier = Modifier.background(Color.White),
        //Dentro de nuestro Scaffold añadimos el composable snackbar para poder colocar los mensajes
        snackbarHost = { SnackbarHost(snackbarHostState)},
        //Añadimos el boton flotante
        floatingActionButton = {
            FloatingActionButton(
                //Evento para el click
                onClick = {navController.navigate(Screen.AddEditAnimeScreen.ruta)}
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Añadir Anime")
            }
        }
    )
    {   contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)){
            /* El control de los datos lo realiza ahora el ViewModel */
            var valor by remember { mutableStateOf("")}
            //var animesLocal by remember { mutableStateOf(animes) }
            if(valor.isNotEmpty()){
                Text(
                    text = "Tu valor es $valor",
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            //Composable editable
            OutlinedTextField(
                modifier = Modifier.padding(bottom = 8.dp),
                value = valor,
                maxLines = 1,
                onValueChange = { valor = it},
                label = { Text("texto") }
            )
            //Listado de Animes
            LazyColumn (modifier = Modifier
                .border(5.dp,color= Color.Blue)
                .fillMaxSize()
            )
            {

                animesViewModel.animesVM.value.forEach { anime ->
                    item{
                        /*Lambda final, el ultipo param es una funtion type*/
                        AnimeCard(navController,anime){
                            //Directamente este es el parámetro pasado para el onDeleteClick
                            println("Borrando Anime")
                            //Es ne necesario modificar animesLocal para actualizar el composable
                            //Podemos usar el filtro de todos los animes excepto anime
                            //En este punto estamo dentro del delete del anime
                            //animesLocal = animesLocal.filter { it != anime }.toMutableList()
                            animesViewModel.onDeleteAnime(anime)
                            //Mostramos el mensaje
                            //NEcesitamos lanzar el snackbar en otro hilo/courutine
                            scope.launch {
                                snackbarHostState.showSnackbar("Borrado de un anime")
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }

}