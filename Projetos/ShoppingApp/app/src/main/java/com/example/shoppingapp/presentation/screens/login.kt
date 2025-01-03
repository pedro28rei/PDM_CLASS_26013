package com.example.shoppingapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shoppingapp.presentation.components.CustomButton
import com.example.shoppingapp.presentation.components.CustomTextField
import com.example.shoppingapp.presentation.navigation.Routes

// Login screen of app
@Composable
fun LoginScreen(navController: NavController) {
    // Estados para email e senha
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
                    CustomTextField(
                        placeholder = "Escreva aqui...",
                        value = email,
                        onValueChange = { email = it }
                    )
                }

                // Password Text Field
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .padding(bottom = 32.dp)
                ) {
                    Text(
                        text = "Palavra-Passe",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    CustomTextField(
                        placeholder = "Escreva aqui...",
                        value = password,
                        onValueChange = { password = it }
                    )
                }

                // Button for user try to login on application, and then navigate to home page
                CustomButton(
                    label = "LOGIN",
                    color = Color.Black,
                    onClick = { navController.navigate(Routes.HOME)}, // Ação de login
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )

                // Clickable Text for User navigate to Start screen
                Text(
                    text = "Voltar atrás",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    ),
                    modifier = Modifier
                        .clickable { navController.navigate(Routes.START) }
                )
            }
        }
    }
}
