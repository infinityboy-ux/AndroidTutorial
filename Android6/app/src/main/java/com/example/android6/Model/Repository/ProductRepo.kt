package com.example.android6.Model.Repository

import com.example.android6.Model.API.ApiService
import com.example.android6.Model.Data.Product

class ProductRepo(private val apiService: ApiService){
    suspend fun getProducts():List<Product>{
        return apiService.getProducts()
    }
}