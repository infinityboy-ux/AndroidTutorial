package com.example.androidui4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidui4.ui.theme.AndroidUI4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidUI4Theme {
                AppNavigate()
            }
        }
    }
}

@Composable
fun AppNavigate() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomeScreen") {
        composable("HomeScreen") { Screen1(navController) }
        composable("Screen2") { Screen2(navController) }
        composable("Screen3") { Screen3(navController) }
    }
}

@Composable
fun Screen1(navController: NavController) {
    Column {
        Button(onClick = { navController.navigate("Screen2") }) {
            Text(text = "List")
        }
        Button(onClick = { navController.navigate("Screen3") }) {
            Text(text = "Grid")
        }
    }
}

@Composable
fun Screen2(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(onClick = { navController.popBackStack("HomeScreen", false) }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }
        Text(text = "List")
        val itemsList = List(50) { "Item : $it" }
        LazyColumn(
            modifier = Modifier
                .height(400.dp)
                .width(100.dp)
                .padding(5.dp)
                .border(2.dp, Color.Black)
        ) {
            items(itemsList.size) { index ->
                BasicText(text = itemsList[index], modifier = Modifier.padding(2.dp))
            }
        }
    }
}

@Composable
fun Screen3(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(onClick = { navController.popBackStack("HomeScreen", false) }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }
        val itemsList = List(50) { "Item : $it" }
        LazyVerticalGrid(
            columns = GridCells.Adaptive(100.dp),
            modifier = Modifier
                .height(500.dp)
                .padding(2.dp)
                .border(2.dp, Color.Black)
        ) {
            items(itemsList.size) { index ->
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .border(1.dp, Color.Gray)
                        .padding(8.dp)
                ) {
                    BasicText(text = itemsList[index])
                }
            }
        }
    }
}
