package com.example.android8.Image

import android.content.Context
import android.net.Uri
import android.widget.Toast
import com.example.android8.StorageRef
import java.util.UUID

fun uploadImage(uri: Uri, context: Context) {
    val filename="images/${UUID.randomUUID()}.jpg"
    val imageRef = StorageRef.child(filename)

    imageRef.putFile(uri).addOnSuccessListener {taskSnapshot ->
        imageRef.downloadUrl.addOnSuccessListener { uri ->
            Toast.makeText(context, "Image Uploaded Successfully:$uri", Toast.LENGTH_LONG).show()
        }

    }.addOnFailureListener{e->
        Toast.makeText(context, "Image Upload Failed:${e.message}", Toast.LENGTH_LONG).show()
    }
}