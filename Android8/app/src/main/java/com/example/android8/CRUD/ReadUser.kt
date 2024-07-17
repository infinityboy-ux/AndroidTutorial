package com.example.android8.CRUD

import android.content.ContentValues.TAG
import android.util.Log
import com.example.android8.Model.User
import com.example.android8.db

fun readUser(onResult: (List<User>) -> Unit){
    db.collection("users")
        .get()
        .addOnSuccessListener { result ->
            val userList=result.map { document ->document.toObject(User::class.java) }
            onResult(userList)
        }
        .addOnFailureListener { e->
            Log.w(TAG, "Error adding document", e)
        }

}