package com.example.shoppingapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shoppingapp.R
import com.example.shoppingapp.presentation.components.CustomButton
import com.example.shoppingapp.presentation.navigation.Routes
import com.example.shoppingapp.ui.theme.LightBlue

@Composable
fun PerfilScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Upper half of screen
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
        ) {
            // Logo of App
            Image(
                painter = painterResource(id = R.drawable.perfil),
                contentDescription = "Top Image",
                modifier = Modifier.fillMaxSize()
            )
        }

        // Parte inferior da tela com informações do perfil
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .align(Alignment.BottomCenter)
                .background(Color.Red)
        ) {

            // Coluna para os campos de perfil
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Name Field
                Text(
                    text = "Name: João Silva",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                // NIF Field
                Text(
                    text = "NIF: 123456789",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                // Birthdate Field
                Text(
                    text = "Birthdate: 01/01/1990",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                // Email Field
                Text(
                    text = "Email: joao.silva@example.com",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                // Password Field
                Text(
                    text = "Password: ********",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                // Button for user back to home page
                CustomButton(
                    label = "GO BACK",
                    color = Color.Black,
                    onClick = { navController.navigate(Routes.HOME)},
                    modifier = Modifier
                        .padding(top = 45.dp)
                )
            }
        }
    }
}