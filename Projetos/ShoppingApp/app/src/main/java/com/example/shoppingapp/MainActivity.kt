package com.example.shoppingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoppingapp.presentation.navigation.AppNavigation
import com.example.shoppingapp.presentation.viewmodels.AuthViewModel
import com.example.shoppingapp.presentation.viewmodels.DataViewModel
import com.example.shoppingapp.presentation.viewmodels.ProductViewModel
import com.example.shoppingapp.presentation.viewmodels.PurchaseViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val dataViewModel: DataViewModel = viewModel()
            val productViewModel: ProductViewModel = viewModel()
            val purchaseViewModel: PurchaseViewModel = viewModel()
            val authViewModel: AuthViewModel = viewModel()


            AppNavigation(
                authViewModel = authViewModel,
                dataViewModel = dataViewModel,
                productViewModel = productViewModel,
                purchaseViewModel = purchaseViewModel
            )
                }
            }
}
