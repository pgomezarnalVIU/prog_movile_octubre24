package es.viu.animedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import es.viu.animedb.presentation.list.ListAnimesScreen
import es.viu.animedb.presentation.list.ListAnimesViewModel
import es.viu.animedb.ui.theme.AnimeDBTheme
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import es.viu.animedb.presentation.utils.Screen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimeDBTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //Controller dentro JetPack Compose
                    val navController = rememberNavController()

                    //Hosts de ventanas
                    NavHost(
                        navController = navController,
                        startDestination = Screen.AnimesListScreen.route,
                        modifier = Modifier.padding(innerPadding)
                    ){
                        composable (route = Screen.AnimesListScreen.route){
                            val animes: ListAnimesViewModel by viewModels()
                            ListAnimesScreen(animes,innerPadding)
                        }
                    }
                }
            }
        }
    }
}
