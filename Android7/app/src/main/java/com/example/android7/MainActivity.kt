package com.example.android7

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android7.ui.theme.Android7Theme
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android7Theme {
                AppNavigate()
            }
        }
    }
}

val auth = FirebaseAuth.getInstance()

fun signIn(email: String, password: String, context: android.content.Context) {
    auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
        if (task.isSuccessful) {
            Toast.makeText(context, "Sign In Successful", Toast.LENGTH_SHORT).show()
            val user = auth.currentUser
            println(user?.uid)
        } else {
            Toast.makeText(
                context,
                "Sign In Failed: ${task.exception?.message}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

fun signUp(email: String, password: String, context: android.content.Context) {
    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
        if (task.isSuccessful) {
            Toast.makeText(context, "Sign Up Successful", Toast.LENGTH_SHORT).show()
            val user = auth.currentUser
            println(user?.uid)
        } else {
            Toast.makeText(
                context,
                "Sign Up Failed: ${task.exception?.message}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

@Composable
fun SignInScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var pwVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                modifier = Modifier.padding(25.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFEFF4FA))
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(20.dp)
                ) {
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .fillMaxWidth(),
                        label = { Text("Email ID") }
                    )
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        modifier = Modifier
                            .padding(vertical = 10.dp)
                            .fillMaxWidth(),
                        label = { Text("Password") },
                        visualTransformation = if (pwVisible) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                        trailingIcon = {
                            IconButton(onClick = { pwVisible = !pwVisible }) {
                                Icon(
                                    imageVector = if (pwVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                    contentDescription = "Toggle Password Visibility"
                                )
                            }
                        }
                    )
                    Button(
                        onClick = { signIn(email, password, context) },
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .fillMaxWidth()
                    ) {
                        Text(text = "Login", fontSize = 16.sp)
                    }
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Text("Don't have an account?")
                TextButton(onClick = { navController.navigate("SignUpScreen") }) {
                    Text("Sign Up")
                }
            }
        }
    }
}

@Composable
fun SignUpScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var pwVisible by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        contentAlignment = Alignment.Center
    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            modifier = Modifier.padding(25.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFEFF4FA))
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(20.dp)
            ) {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .fillMaxWidth(),
                    label = { Text("Email ID") }
                )
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier
                        .padding(vertical = 10.dp)
                        .fillMaxWidth(),
                    label = { Text("Create Password") },
                    visualTransformation = if (pwVisible) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },
                    trailingIcon = {
                        IconButton(onClick = { pwVisible = !pwVisible }) {
                            Icon(
                                imageVector = if (pwVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = "Toggle Password Visibility"
                            )
                        }
                    }
                )
                Button(
                    onClick = { signUp(email, password, context) },
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "Sign Up", fontSize = 16.sp)
                }
            }
        }
    }
}

@Composable
fun AppNavigate() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "SignInPage") {
        composable("SignInPage") { SignInScreen(navController) }
        composable("SignUpScreen") { SignUpScreen(navController) }
    }
}
