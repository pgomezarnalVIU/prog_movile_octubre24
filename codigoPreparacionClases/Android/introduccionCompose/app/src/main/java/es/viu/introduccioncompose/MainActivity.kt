package es.viu.introduccioncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import es.viu.introduccioncompose.ui.theme.IntroduccionComposeTheme
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.ui.layout.ContentScale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntroduccionComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PersonalCardRow(
                        modifier = Modifier.padding(innerPadding)
                    )
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



@Composable
fun PersonalCardRow(modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = modifier) {
        PersonalAvatar()
        PersonalCard(modifier)
    }
}

@Composable
fun PersonalCard(modifier: Modifier = Modifier) {
    Column {
        Text("Paco Gomez")
        Text("hace 10 minutos")
    }
}
@Composable
fun PersonalAvatar(modifier: Modifier = Modifier) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.paco), // Asegúrate de tener esta imagen en drawable
            contentDescription = "Imagen de Paco"
        )
        Icon(Icons.Filled.Check, contentDescription = "Check mark")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntroduccionComposeTheme {
        Greeting("Android")
    }
}