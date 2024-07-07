package com.example.androidui3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidui3.ui.theme.AndroidUI3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidUI3Theme {
                ScaffoldExample()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Top app bar")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom app bar",
                )
            }
        }    
    )
    {innerPadding ->
        var sheetState = rememberModalBottomSheetState()
        var showBottomSheet by remember {
            mutableStateOf(false)
        }
        var showAlert by remember {
            mutableStateOf(false)
        }
        var text by remember {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            Row{
                Text(text = "Hello Siliconoites ! My Name is Pradyumna", fontSize = 30.sp)
            }
            Row {
                    Button(onClick = { showBottomSheet=true}) {
                        Text(text = "Show Bottom Sheet")

                    }
            }
            Row{
                Button(onClick = {showAlert=true}) {
                    Text(text = "Show Alert")
                    
                }
            }
            Row{
                TextField(modifier = Modifier.padding(10.dp), value = text,
                    onValueChange = {text = it},
                    label = {Text("Username: ")}
                )
                Text (text)

            }


        }
        if(showBottomSheet){
            ModalBottomSheet(onDismissRequest = { showBottomSheet = false },
                sheetState=sheetState,
                containerColor= Color(0xFFEFF4FA)
            ) {
                Column(modifier  = Modifier
                    .padding(10.dp)
                    .fillMaxSize()) {
                    Text(text ="Hi, This is a Bottom Sheet")
                    

                }
            }


        }
        if (showAlert){
            AlertDialog(
                icon = {Icon(Icons.Filled.Done, contentDescription = "Done")},
                title = {
                        Text(text = "Alert")
                }, 
                text = {
                       Text(text = "Compose is updating ")
                }, 
                onDismissRequest = {showAlert=false},
                confirmButton = { TextButton(onClick = { println("Clicked on the text button") }) {
                    Text(text = "Alright")
                    
                } }
            )
            
        }

    }
}


