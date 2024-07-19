package com.example.android8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.android8.Screen.imageUploadScreen
import com.example.android8.ui.theme.Android8Theme
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.storage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            Android8Theme {
                imageUploadScreen()

            }
        }
    }
}

val db = Firebase.firestore
val storage = Firebase.storage
val StorageRef = storage.reference





















