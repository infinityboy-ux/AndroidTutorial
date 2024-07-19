package com.example.android8.Screen

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.android8.Image.uploadImage

@Composable
fun imageUploadScreen() {
    val context= LocalContext.current
    val imageUri = remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        imageUri.value = uri
        uri?.let { uploadImage(uri, context) }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = { launcher.launch("image/*") }) {
            Text(text = "Upload Image")
        }
        Spacer(modifier = Modifier.height(16.dp))
        imageUri.value?.let {uri->
            Image(painter = rememberAsyncImagePainter(uri), contentDescription = null,modifier = Modifier.size(200.dp))
        }
    }

}