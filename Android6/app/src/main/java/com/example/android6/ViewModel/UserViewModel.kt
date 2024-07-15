package com.example.android6.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android6.Model.API.RetrofitClient
import com.example.android6.Model.Data.Product
import com.example.android6.Model.Data.User
import com.example.android6.Model.Repository.ProductRepo
import com.example.android6.Model.Repository.UserRepo
import kotlinx.coroutines.launch

class UserViewModel: ViewModel(){
    private val _user= MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _user

    private val repository = UserRepo(RetrofitClient.apiService)

    init {
        fetchUsers()
    }

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val userList = repository.getUsers()
                _user.postValue(userList)
            } catch (e: Exception) {

            }
        }
    }
}