package com.example.android8.CRUD

import com.example.android8.db

fun updateUser(name: String, age: Int, sic: String) {

    val updates = mapOf(
        "name" to name,
        "age" to age
    )

    db.collection("users").document(sic)
        .update(updates)
        .addOnSuccessListener {
            println("User successfully updated")
        }
        .addOnFailureListener { e ->
            println("Error updating user: $e")
        }
}