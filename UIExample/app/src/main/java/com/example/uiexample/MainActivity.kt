package com.example.uiexample

import android.graphics.drawable.Icon
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uiexample.ui.theme.UIExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            UIExampleTheme {
                Column {
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 2.dp
                        ),
                        modifier = Modifier
                            .size(600.dp,645.dp)
                            .padding(25.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFEFF4FA),
                        )
                    ){
                        Spacer(modifier = Modifier.size(40.dp))
                        Text(text = "Jetpack Compose", modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            , Color(0xFF085C8F), fontSize = 24.sp
                        )
                       Image(painter = painterResource(id = R.drawable.jetpack) , contentDescription = "Jetpack",
                           modifier = Modifier
                               .size(100.dp)
                               .align(Alignment.CenterHorizontally)
                       )
                        Spacer(modifier = Modifier.size(10.dp))
                       Text(text = "Login", modifier = Modifier.padding(20.dp),
                           Color(0xFF026B3A),fontSize = 30.sp
                       )
                        var text by remember {
                            mutableStateOf("")
                        }
                        var pw by remember {
                            mutableStateOf("")
                        }
                        var pwvisible by remember {
                            mutableStateOf(false)
                        }
                        OutlinedTextField(value = text,
                            onValueChange = {text = it},
                            modifier = Modifier
                                .padding(20.dp, 10.dp)
                                .size(300.dp, 67.dp),
                            label = {Text("Email ID or Mobile Number")}
                        )
                        OutlinedTextField(value = pw, onValueChange = {pw=it},
                            modifier = Modifier
                                .padding(20.dp, 10.dp)
                                .size(300.dp, 67.dp),
                            label = {Text("Password")},
                            visualTransformation = if (pwvisible) {
                                VisualTransformation.None
                            } else {
                                PasswordVisualTransformation()
                            },
                            trailingIcon = {
                                if (pwvisible){
                                    IconButton(onClick = {pwvisible=false}) {
                                        androidx.compose.material3.Icon(painter = painterResource(id =
                                        R.drawable.visible
                                        ), modifier = Modifier.size(20.dp), contentDescription = "")
                                        
                                    }

                                }
                                else{
                                    IconButton(onClick = {pwvisible=true}) {
                                        androidx.compose.material3.Icon(
                                            painter = painterResource(id =R.drawable.vision),
                                            contentDescription = "", modifier = Modifier.size(20.dp)
                                        )
                                    }
                                }



                            }
                        )
                        Text(text = "Forget Password?", modifier = Modifier
                            .padding(0.dp, 0.dp, 20.dp, 0.dp)
                            .align(Alignment.End),
                            Color(0xFF026B3A)
                        )
                        Button(onClick = { println("Login Successful")}, modifier = Modifier
                            .padding(20.dp)
                            .size(120.dp, 60.dp)) {
                            Text(text = "Login", fontSize = 13.sp)


                        }
                        

                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth().padding(1.dp)
                    ) {
                        Text("Don't have an account?")
                        TextButton(onClick = { "Register done" }) {
                            Text("Register")
                        }
                    }

                }

            }
        }
    }
}

