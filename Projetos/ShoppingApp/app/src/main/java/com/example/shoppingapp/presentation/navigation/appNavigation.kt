package com.example.shoppingapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shoppingapp.presentation.screens.HomeScreen
import com.example.shoppingapp.presentation.screens.LoginScreen
import com.example.shoppingapp.presentation.screens.PaymentScreen
import com.example.shoppingapp.presentation.screens.PerfilScreen
import com.example.shoppingapp.presentation.screens.ProductScreen
import com.example.shoppingapp.presentation.screens.ShoppingCarScreen
import com.example.shoppingapp.presentation.screens.StartScreen

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Routes.START
    ) {
        // Screen Start
        composable(Routes.START) {
           StartScreen(navController)
        }

        // Screen Login
        composable(Routes.LOGIN) {
            LoginScreen(navController)
        }

        // Screen Home
        composable(Routes.HOME) {
            HomeScreen(navController)
        }

        // Screen Perfil
        composable(Routes.PERFIL) {
            PerfilScreen(navController)
        }

        // Screen Product
        composable(Routes.PRODUCT) {
            ProductScreen(navController)
        }

        // Screen Shopping Car
        composable(Routes.SHOPPINGCAR) {
            ShoppingCarScreen(navController)
        }

        // Screen Payment
        composable(Routes.PAYMENT) {
            PaymentScreen(navController)
        }
    }
}