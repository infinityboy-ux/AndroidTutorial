package com.example.android6.Model.API

import com.example.android6.Model.Data.Product
import com.example.android6.Model.Data.User
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>
    @GET("users")
    suspend fun getUsers(): List<User>
}