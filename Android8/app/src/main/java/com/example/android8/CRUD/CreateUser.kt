package com.example.android8.CRUD

import android.content.ContentValues.TAG
import android.util.Log
import com.example.android8.Model.User
import com.example.android8.db

fun addUser(name:String,age:Int,sic:String){
    val user = User(name,age)
    db.collection("users")
        .document(sic)
        .set(user)
        .addOnFailureListener { e ->
            Log.w(TAG, "Error adding document", e)
        }
}