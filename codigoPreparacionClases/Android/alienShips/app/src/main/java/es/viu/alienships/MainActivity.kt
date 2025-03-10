package es.viu.alienships

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import es.viu.alienships.ui.theme.AlienShipsTheme
import es.viu.alienships.ui.theme.BackGround

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlienShipsTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text(text="SCORE:1000",color=Color.White) },
                            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                                containerColor = BackGround))
                    },
                    containerColor = BackGround
                )
                { innerPadding ->
                    Column{
                        AndroidAliensRow(
                            modifier = Modifier.padding(innerPadding)
                        )
                        AndroidAliensRow(
                            modifier = Modifier.padding(innerPadding)
                        )
                        Row(
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ){
                            Text(
                                text = "GAME OVER",
                                color = Color.White,
                                fontSize = 24.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.Bold
                            )
                        }

                    }

                }
            }
        }
    }
}


/*Agrupacion de componentes*/
@Composable
fun AndroidAliensRow(modifier: Modifier = Modifier) {
    Row(
        modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top
    ) {
        AndroidAlien(
            color = Color.Red,
            modifier = Modifier
                .size(70.dp)
                .padding(4.dp)
        )
        AndroidAlien(
            color = Color.Green,
            modifier = Modifier
                .size(70.dp)
                .padding(4.dp)
        )
        AndroidAlien(
            color = Color.Red,
            modifier = Modifier
                .size(70.dp)
                .padding(4.dp)
        )
        AndroidAlien(
            color = Color.Green,
            modifier = Modifier
                .size(70.dp)
                .padding(4.dp)
        )
    }
}

/*Componente individual*/
@Composable
fun AndroidAlien(color: Color, modifier: Modifier = Modifier){
    Image(
        painter = painterResource(R.drawable.space_invader),
        contentDescription = "space invader alien",
        colorFilter = ColorFilter.tint(color = color),
        modifier = modifier
    )
}
