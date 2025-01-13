package com.example.shoppingapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shoppingapp.presentation.components.CustomButton
import com.example.shoppingapp.presentation.navigation.Routes

@Composable
fun ShoppingCarScreen(navController: NavController) {
    var text by remember { mutableStateOf("") } // Estado para o texto do campo

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp) // Padding geral
        ) {
            // Lista de produtos
            LazyColumn(
                modifier = Modifier
                    .weight(1f) // Ocupa o espaço restante
                    .padding(bottom = 16.dp)
            ) {
                items(7) { index ->
                    Text(
                        text = "Produto ${index + 1}",
                        color = Color.White,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                            .background(Color.DarkGray)
                            .fillMaxWidth()
                            .padding(16.dp) // Padding interno do item
                    )
                }
            }
            Text(
                text = "Your Cart Code: XR456DD",
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                ),
                modifier = Modifier
                    .clickable { navController.navigate(Routes.HOME) }
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp)
            )

            // Pay button
            CustomButton(
                label = "PAY",
                color = Color.Black,
                onClick = { /* Lógica para pagamento */ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 19.dp)
            )

            // Campo de texto
            OutlinedTextField(
                value = text,
                onValueChange = { newText -> text = newText },
                label = { Text("Enter cart code") },
                placeholder = { Text("Insira seu texto aqui") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Pay button
            CustomButton(
                label = "SEARCH",
                color = Color.Blue,
                onClick = { /* Lógica para pagamento */ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp)
            )

            // Navigate to home page
            Text(
                text = "Back to Shop",
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                ),
                modifier = Modifier
                    .clickable { navController.navigate(Routes.HOME) }
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp)
            )
        }
    }
}
