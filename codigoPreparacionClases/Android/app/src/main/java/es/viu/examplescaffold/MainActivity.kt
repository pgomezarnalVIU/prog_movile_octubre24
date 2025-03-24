package es.viu.examplescaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import es.viu.examplescaffold.ui.theme.ExampleScaffoldTheme
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExampleScaffoldTheme {
                Scaffold(
                    topBar = { TopBar() },
                    bottomBar = { FooterBar() },
                    modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ContentCards(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Mi Aplicación") },
        navigationIcon = {
            IconButton(onClick = { /* Acción de navegación */ }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menú")
            }
        }
    )
}

@Composable
fun FooterBar() {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = { /* Acción de navegación en el Footer */ },
            icon = { Icon(Icons.Filled.Menu, contentDescription = "Inicio") },
            label = { Text("Inicio") }
        )
    }
}

@Composable
fun ContentCards(modifier: Modifier = Modifier) {
    val itemsList = listOf("Contenido Card 1", "Contenido Card 2", "Contenido Card 3", "Contenido Card 4")

    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = itemsList[0])
                    }
                }

            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = itemsList[1])
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
    ExampleScaffoldTheme {
        Greeting("Android")
    }
}