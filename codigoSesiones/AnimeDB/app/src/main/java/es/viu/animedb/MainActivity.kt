package es.viu.animedb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import es.viu.animedb.presentation.ListAnimesScreen
import es.viu.animedb.presentation.animes
import es.viu.animedb.ui.theme.AnimeDBTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimeDBTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ListAnimesScreen(animes,innerPadding)
                }
            }
        }
    }
}
