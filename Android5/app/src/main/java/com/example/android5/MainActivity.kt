package com.example.android5


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.android5.ui.theme.Android5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: CounterViewModel by viewModels()
            Android5Theme {
                CounterView(counterVM = viewModel)
            }
        }
    }
}

@Composable
fun CounterView(counterVM: CounterViewModel) {

    val counterState by counterVM.counter

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Current Counter Value: ${counterState.count}")
        Row {
            Button(onClick = { counterVM.increment() }) {
                Text(text = "Increment")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(onClick = { counterVM.decrement() }) {
                Text(text = "Decrement")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(onClick = { counterVM.reset() }) {
                Text(text = "Reset")
            }
        }
    }
}


data class Counter(val count: Int)

class CounterViewModel : ViewModel() {
    private val _counter = mutableStateOf(Counter(0))
    val counter: State<Counter> = _counter

    fun increment() {
        _counter.value = Counter(_counter.value.count + 1)
    }

    fun decrement() {
        _counter.value = Counter(_counter.value.count - 1)
    }

    fun reset() {
        _counter.value = Counter(0)
    }
}


