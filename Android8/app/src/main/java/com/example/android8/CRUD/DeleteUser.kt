package com.example.android8.CRUD

import com.example.android8.db

fun deleteUser(sic: String) {
    db.collection("users").document(sic)
        .delete()
        .addOnSuccessListener {
            println("User successfully deleted")
        }
        .addOnFailureListener { e ->
            println("Error deleting user: $e")
        }
}