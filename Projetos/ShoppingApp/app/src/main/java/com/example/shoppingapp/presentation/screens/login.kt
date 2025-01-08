package com.example.shoppingapp.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shoppingapp.presentation.components.CustomButton
import com.example.shoppingapp.presentation.components.CustomTextField
import com.example.shoppingapp.presentation.navigation.Routes
import com.example.shoppingapp.presentation.viewmodels.AuthState
import com.example.shoppingapp.presentation.viewmodels.AuthViewModel


// Login screen of app
@Composable
fun LoginScreen(modifier: Modifier = Modifier, authViewModel: AuthViewModel, navController: NavHostController) {


    // Estados para email e senha
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current


    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated -> navController.navigate(Routes.HOME)
            is AuthState.Error -> Toast.makeText(context, (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Upper half of screen
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.55f)
        ) {
            // Logo of App
            Image(
                painter = painterResource(id = com.example.shoppingapp.R.drawable.logo),
                contentDescription = "Top Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Lower half of the screen
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.45f)
                .align(Alignment.BottomCenter)
                .background(Color.Red)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp, top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Email Text Field
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .padding(bottom = 16.dp)
                ) {
                    Text(
                        text = "Email",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it},
                        placeholder = { Text(text = "Type here...") },
                        label = {
                            Text(text = "Type here...")
                        }
                    )
                }

                // Password Text Field
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .padding(bottom = 32.dp)
                ) {
                    Text(
                        text = "Password",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it},
                        placeholder = { Text(text = "Type here...") },
                        label = {
                            Text(text = "Type here...")
                        },
                        visualTransformation = PasswordVisualTransformation()

                    )
                }

                // Button for user try to login on application, and then navigate to home page
                CustomButton(
                    label = "LOGIN",
                    color = Color.Black,
                    onClick = { authViewModel.login(email, password)},
                    //enabled = authState.value != AuthState.Loading,// Ação de login
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )

                // Clickable Text for User navigate to Regist screen without login done
                Text(
                    text = "New? Create account",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    ),
                    modifier = Modifier
                        .padding(bottom = 3.dp)
                        .clickable { navController.navigate(Routes.REGIST) }
                )

                // Clickable Text for User navigate to Start screen
                Text(
                    text = "Go back",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    ),
                    modifier = Modifier
                        .padding(bottom = 3.dp)
                        .clickable { navController.navigate(Routes.START) }
                )
            }
        }
    }
}
