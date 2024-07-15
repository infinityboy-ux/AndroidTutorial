package com.example.android6.Views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.Modifier
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.android6.Model.Data.Product
import com.example.android6.Model.Data.Rating
import com.example.android6.ViewModel.ProductViewModel


@Composable
fun ProductScreen(productVM:ProductViewModel){
    val products by productVM.products.observeAsState(emptyList())
    LazyColumn {
        items(products){
            productItem(product = it)
        }

    }


}
@Composable
fun productItem(product: Product){
    Card(
        modifier = Modifier
            .size(200.dp, 346.667.dp)
            .padding(10.dp)

    ) {
        Column {
            Row {
                
            }
            AsyncImage(
                model = product.image,
                contentDescription = " ",
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .size(150.dp)
                    .border(BorderStroke(1.dp, Color.Black))
                    .align(Alignment.CenterHorizontally)
            )
            RatingBar(rating = product.rating)
            Text(text = product.title,Modifier.fillMaxWidth().padding(2.5.dp), fontWeight = FontWeight.Bold)
            Text(text = "${product.price}$", modifier = Modifier.padding(2.5.dp))
        }

    }
}

@Composable
fun RatingBar(rating:Rating, maxRating: Int = 5) {

        Row {
            for (i in 1..maxRating) {
                if (i <= rating.rate) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null,
                        tint = Color.Yellow,
                        modifier = Modifier.size(24.dp)
                    )
                } else {
                    Icon(
                        imageVector = Icons.Outlined.Star,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
            Text(text = "(${rating.count})", color = Color.Gray,
            modifier = Modifier.padding(start = 8.dp)
            )
        }



}