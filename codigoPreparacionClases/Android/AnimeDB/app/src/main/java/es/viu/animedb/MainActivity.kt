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
import es.viu.animedb.ui.theme.AnimeDBTheme
import es.viu.animedb.presentation.ListAnimesScreen
import es.viu.animedb.presentation.animes

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
                    ListAnimesScreen(animes, innerPadding)
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