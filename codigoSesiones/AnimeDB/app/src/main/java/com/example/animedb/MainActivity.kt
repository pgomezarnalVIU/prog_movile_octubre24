package com.example.animedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.room.Room
import com.example.animedb.data.source.AnimesDataBase
import com.example.animedb.screens.AddEditBookScreen
import com.example.animedb.screens.ListAnime
import com.example.animedb.screens.Screen
import com.example.animedb.ui.theme.AnimeDBTheme
import com.example.animedb.viewmodel.AddEditAnimeViewModel
import com.example.animedb.viewmodel.ListAnimeViewModel

class MainActivity : ComponentActivity() {

    //Cuando se lance la aplicación Android debemos crear la BBDD
    //Podemos mejorar el rendimiendo usando by lazy --> cuando se utilice se crea ahora no
    private val db by lazy{
        Room.databaseBuilder(
            //El contexto es el entorno donde creamos la BBDD, en este caso la app
            applicationContext,
            //La clase que hemos creado antes de BBDD
            AnimesDataBase::class.java,
            //El nombre de la base de datos
            AnimesDataBase.DATABASE_NAME
        ).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimeDBTheme {
                Scaffold(modifier = Modifier.safeDrawingPadding()) { innerPadding ->
                    //Creamos el controlador de navegación
                    val navController = rememberNavController()

                    //Creamos el Host con las rutas a las pantallas
                    NavHost(
                        navController=navController,
                        startDestination = Screen.AnimeListScreen.ruta,
                        modifier = Modifier.padding(innerPadding)
                    ){
                        //Configuramos la primera ruta
                        composable(route=Screen.AnimeListScreen.ruta) {
                            //Cuando se llama a esta ruta qué hacemos
                            //Creamos el ViewModel que forme parte del composable
                            val animes = viewModel<ListAnimeViewModel>{
                                ListAnimeViewModel(db.dao)
                            }
                            //Le pasamoa a la vista nuestro ViewModel
                            ListAnime(navController,animes)
                        }
                        //Configuramos la segunda ruta
                        composable(route=Screen.AddEditAnimeScreen.ruta+"?animeId={animeId}",
                            arguments = listOf(
                                navArgument(name="animeId"){
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ) {
                            //Pasamos el stack de argumentos
                            navBackStackEntry ->
                                //Capturamos el animeId, teniendo en cuenta que puede ser null
                                //Además del defaultValue, se puede indicar un valor por defecto
                                val animeId = navBackStackEntry.arguments?.getInt("animeId") ?: -1
                                //Cuando se llama a esta ruta qué hacemos
                                //Creamos el ViewModel que forme parte del composable
                                val anime = viewModel<AddEditAnimeViewModel>() {
                                    AddEditAnimeViewModel(db.dao,animeId)
                                }
                                //Le pasamoa a la vista nuestro ViewModel
                                AddEditBookScreen(navController, anime)
                        }
                    }
                }
            }
        }
    }
}