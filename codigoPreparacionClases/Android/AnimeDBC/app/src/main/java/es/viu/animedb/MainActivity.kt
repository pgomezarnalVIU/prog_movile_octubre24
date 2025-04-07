package es.viu.animedb


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import es.viu.animedb.presentation.addedit.AddEditAnimeScreen
import es.viu.animedb.presentation.addedit.AddEditAnimeViewModel
import es.viu.animedb.ui.theme.AnimeDBTheme
import es.viu.animedb.presentation.list.ListAnimesScreen
import es.viu.animedb.presentation.list.ListAnimesViewModel
import es.viu.animedb.presentation.utils.Screen

class MainActivity : ComponentActivity() {

    override fun onStart() {
        super.onStart()
        println("called onStart()")
    }

    override fun onResume() {
        super.onResume()
        println("called onResume()")
    }

    override fun onPause() {
        super.onPause()
        println("called onPause()")
    }

    override fun onStop() {
        super.onStop()
        println("called onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("called onDestroy()")
    }

    override fun onRestart() {
        super.onRestart()
        println("called onRestart()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        println("called onCreate()")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimeDBTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //Controlador de navegación
                    val navController = rememberNavController()

                    //Host de pantallas
                    NavHost(
                        navController = navController,
                        startDestination = Screen.AnimesListScreen.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable (route = Screen.AnimesListScreen.route)
                        {
                            val animes: ListAnimesViewModel by viewModels()
                            ListAnimesScreen(navController,animes)
                        }
                        composable (route = Screen.AddEditAnimeScreen.route+"?animeId={animeId}",
                            arguments = listOf(
                                navArgument (name = "animeId"){
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            ))
                        {navBackStackEntry->
                            val animeId:Int = navBackStackEntry.arguments?.getInt("animeId")?:-1
                            val anime = viewModel <AddEditAnimeViewModel>() {
                                AddEditAnimeViewModel(animeId)
                            }
                            AddEditAnimeScreen(navController,anime)
                        }

                    }
                    /*
                    val animes: ListAnimesViewModel by viewModels()
                    ListAnimesScreen(animes, modifier = Modifier.padding(innerPadding))
                    */

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnimeDBTheme {
        Greeting("Android")
    }
}