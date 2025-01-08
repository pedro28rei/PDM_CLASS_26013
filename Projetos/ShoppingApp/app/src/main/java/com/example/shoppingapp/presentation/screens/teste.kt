package com.example.shoppingapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.shoppingapp.presentation.viewmodels.DataViewModel
import com.example.shoppingapp.presentation.viewmodels.ProductViewModel
import com.example.shoppingapp.presentation.viewmodels.PurchaseViewModel

@Composable
fun TesteScreen(
    dataViewModel: DataViewModel,  // ViewModel for Users
    productViewModel: ProductViewModel,  // ViewModel for Products
    purchaseViewModel: PurchaseViewModel  // ViewModel for Purchases
) {
    // Users data
    val usersList = dataViewModel.state.value
    val usersLoading = dataViewModel.loading.value
    val usersError = dataViewModel.error.value

    // Products data
    val productsList = productViewModel.state.value
    val productsLoading = productViewModel.loading.value
    val productsError = productViewModel.error.value

    // Purchases data
    val purchasesList = purchaseViewModel.purchasesState.value
    val purchasesLoading = purchaseViewModel.loading.value
    val purchasesError = purchaseViewModel.error.value

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Users section
        if (usersLoading) {
            CircularProgressIndicator()  // Show loading indicator for users
        } else if (usersError != null) {
            Text(text = "Error: $usersError")  // Show error message for users
        } else {
            // Display users list
            Text(text = "Users:")
            usersList.forEach { user ->
                Text(text = "Name: ${user.name}")
                Text(text = "Email: ${user.email}")
                Text(text = "Password: ${user.password}")
                // Separator between users
                Text(text = "------------------------")
            }
        }

        // Spacer between users and products
        Text(text = "\n")  // Line break between users and products

        // Products section
        if (productsLoading) {
            CircularProgressIndicator()  // Show loading indicator for products
        } else if (productsError != null) {
            Text(text = "Error: $productsError")  // Show error message for products
        } else {
            // Display products list
            Text(text = "Products:")
            productsList.forEach { product ->
                Text(text = "Name: ${product.name}")
                Text(text = "Price: ${product.price}")
                Text(text = "Type: ${product.productType}")
                // Separator between products
                Text(text = "------------------------")
            }
        }

        // Spacer between products and purchases
        Text(text = "\n")  // Line break between products and purchases

        // Purchases section
        if (purchasesLoading) {
            CircularProgressIndicator()  // Show loading indicator for purchases
        } else if (purchasesError != null) {
            Text(text = "Error: $purchasesError")  // Show error message for purchases
        } else {
            // Display purchases list
            Text(text = "Purchases:")
            purchasesList.forEach { purchase ->
                Text(text = "Payment Type: ${purchase.paymentType}")
                Text(text = "Purchase ID: ${purchase.purchaseID}")
                Text(text = "Shop Car ID: ${purchase.shopCarID}")
                Text(text = "User ID: ${purchase.userID}")
                Text(text = "Value: ${purchase.value}")
                // Separator between purchases
                Text(text = "------------------------")
            }
        }
    }
}


