package com.example.android6.Model.Data

import com.google.gson.annotations.SerializedName

data class User(
    val id: Int,
    val email: String,
    val username:String,
    val password:String,
    val name:Name
)
data class Name(
    val firstname:String,
    val lastname:String
)