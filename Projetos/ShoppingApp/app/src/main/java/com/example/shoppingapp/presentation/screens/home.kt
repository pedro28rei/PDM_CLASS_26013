package com.example.shoppingapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shoppingapp.presentation.components.CustomButton
import com.example.shoppingapp.presentation.navigation.Routes


// Home screen of app
@Composable
fun HomeScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Bar with buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red),
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {

            // Button to logout the user
            CustomButton(
                label = "Logout",
                color = Color.Black,
                onClick = {
                    // Lógica para fazer logout
                    navController.navigate(Routes.START)
                          },
                modifier = Modifier
            )

            // Button to send user to Profile screen
            CustomButton(
                label = "Profile",
                color = Color.Black,
                onClick = { navController.navigate(Routes.PERFIL) },
                modifier = Modifier
            )

            // Button to send user to Shop Cart screen
            CustomButton(
                label = "Shop Cart",
                color = Color.Black,
                onClick = {navController.navigate(Routes.PRODUCT) },
                modifier = Modifier
            )
        }


        // Product Area
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),  //Nr of procucts per row
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(10) { index -> // Nr of procucts in total
                ProductCard(
                    productName = "Produto ${index + 1}",
                    price = "R$ ${index * 10 + 10}",
                    onAddToCart = {
                    /* Lógica para adicionar ao carrinho */
                    }
                )
            }
        }
    }
}


// Product box
@Composable
fun ProductCard(productName: String, price: String, onAddToCart: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        color = Color.LightGray,
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Product image
            Image(
                painter = painterResource(id = com.example.shoppingapp.R.drawable.logo),
                contentDescription = productName,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = productName,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = price,
                style = MaterialTheme.typography.bodySmall.copy(color = Color.Green)
            )

            Spacer(modifier = Modifier.height(6.dp)) //

            // Button to add product to the cart
            CustomButton(
                label = "Buy",
                color = Color.Black,
                onClick = { }, // Add Product to the cart
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
        }
    }
}
