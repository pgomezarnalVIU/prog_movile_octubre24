package es.viu.composelayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.viu.composelayouts.ui.theme.ComposeLayoutsTheme
import es.viu.composelayouts.ui.theme.L1BoxColor1
import es.viu.composelayouts.ui.theme.L1BoxColor2
import es.viu.composelayouts.ui.theme.L1BoxColor3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeLayoutsTheme {
                Scaffold(modifier = Modifier.fillMaxSize())
                { innerPadding ->
                    ExampleLayout03(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ExampleLayout01(modifier: Modifier = Modifier){
    Column(
        //Modifier.fillMaxWidth()
        //modifier=modifier
        modifier=modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("This is a column")
        Column(
            Modifier.background(L1BoxColor1)
        ) {
            Text("1", modifier = Modifier.testTag("column_one"))
            Text("2", modifier = Modifier.testTag("column_two"))
            Text("3", modifier = Modifier.testTag("column_three"))
            Text("4", modifier = Modifier.testTag("column_four"))
            Text("5", modifier = Modifier.testTag("column_five"))
        }
    }
}

@Composable
fun ExampleLayout02(modifier: Modifier = Modifier){
    Column(
        modifier=modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("This is a row")
        Row(
            Modifier.background(L1BoxColor2)
        ) {
            Text("1", modifier = Modifier.testTag("row_one"))
            Text("2", modifier = Modifier.testTag("row_two"))
            Text("3", modifier = Modifier.testTag("row_three"))
            Text("4", modifier = Modifier.testTag("row_four"))
            Text("5", modifier = Modifier.testTag("row_five"))
        }
    }
}


@Composable
fun ExampleLayout03(modifier: Modifier = Modifier){
    Column(
        modifier=modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("This is a box that with no aligning")
        Box(
            Modifier
                .background(L1BoxColor1)
                .size(200.dp)
        ) {
            Box(
                Modifier
                    .background(L1BoxColor2)
                    .size(150.dp)
            ) {
                Box(
                    Modifier
                        .background(L1BoxColor3)
                        .size(50.dp)
                )
            }
        }
        Spacer(Modifier.height(32.dp))
        Box(
            Modifier
                .background(L1BoxColor3)
                .size(250.dp)
        ) {
            Text("Top Center", Modifier.align(Alignment.TopCenter))
            Text("Center Start", Modifier.align(Alignment.CenterStart))
            Text("Center End", Modifier.align(Alignment.CenterEnd))
            Text("Bottom Center", Modifier.align(Alignment.BottomCenter))
        }
    }

}
