package com.example.android6.Model.Repository

import com.example.android6.Model.API.ApiService
import com.example.android6.Model.Data.Product
import com.example.android6.Model.Data.User

class UserRepo(private val apiService: ApiService){
    suspend fun getUsers():List<User>{
        return apiService.getUsers()
    }
}