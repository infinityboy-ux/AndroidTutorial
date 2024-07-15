package com.example.android6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android6.Model.Data.Product
import com.example.android6.Model.Data.User
import com.example.android6.ViewModel.ProductViewModel
import com.example.android6.ViewModel.UserViewModel
import com.example.android6.Views.ProductScreen
import com.example.android6.Views.UserScreen
import com.example.android6.ui.theme.Android6Theme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            val productVM : ProductViewModel by viewModels()
            val userVM : UserViewModel by viewModels()
            Android6Theme {
                ProductScreen(productVM)
                //UserScreen(userVM )
//                Column(
//                    modifier = androidx.compose.ui.Modifier
//                        .padding(20.dp)
//                        .fillMaxSize(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center
//                ) {
//                    Button(onClick = {
//                        productVM.fetchProducts()
//                    }) {
//                        Text(text = "Click to make an API Call")
//                    }
//                }

            }
        }
    }
}



