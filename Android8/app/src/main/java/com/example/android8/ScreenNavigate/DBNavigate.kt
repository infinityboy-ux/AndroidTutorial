package com.example.android8.ScreenNavigate

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android8.Screen.AddScreen
import com.example.android8.Screen.DeleteScreen
import com.example.android8.Screen.MainScreen
import com.example.android8.Screen.ReadScreen
import com.example.android8.Screen.UpdateScreen

@Composable
fun DBNavigate(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Main Screen") {
        composable("Main Screen") { MainScreen(navController) }
        composable("CreateScreen") {AddScreen(navController)}
        composable("ReadScreen") { ReadScreen(navController) }
        composable("UpdateScreen") { UpdateScreen(navController) }
        composable("DeleteScreen") {DeleteScreen(navController)}
    }
}