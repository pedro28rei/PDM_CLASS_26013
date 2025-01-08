package com.example.shoppingapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shoppingapp.presentation.screens.HomeScreen
import com.example.shoppingapp.presentation.screens.LoginScreen
import com.example.shoppingapp.presentation.screens.PaymentScreen
import com.example.shoppingapp.presentation.screens.PerfilScreen
import com.example.shoppingapp.presentation.screens.ProductScreen
import com.example.shoppingapp.presentation.screens.RegistScreen
import com.example.shoppingapp.presentation.screens.ShoppingCarScreen
import com.example.shoppingapp.presentation.screens.StartScreen
import com.example.shoppingapp.presentation.screens.TesteScreen
import com.example.shoppingapp.presentation.viewmodels.AuthViewModel
import com.example.shoppingapp.presentation.viewmodels.DataViewModel
import com.example.shoppingapp.presentation.viewmodels.ProductViewModel

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel,
    dataViewModel: DataViewModel,
    productViewModel: ProductViewModel,
    navController: NavHostController = rememberNavController()
) {


    NavHost(
        navController = navController,
        startDestination = Routes.START
    ) {
        // Screen Start
        composable(Routes.START) {
           StartScreen(navController = navController, authViewModel = authViewModel)
        }

        // Screen Login
        composable(Routes.LOGIN) {
            LoginScreen(navController = navController, authViewModel = authViewModel)
        }

        // Screen Home
        composable(Routes.HOME) {
            HomeScreen(navController = navController, authViewModel = authViewModel)
        }

        // Screen Perfil
        composable(Routes.PERFIL) {
            PerfilScreen(navController)
        }

        // Screen Product
        composable(Routes.PRODUCT) {
            ProductScreen(navController = navController)
        }

        // Screen Shopping Car
        composable(Routes.SHOPPINGCAR) {
            ShoppingCarScreen(navController)
        }

        // Screen Payment
        composable(Routes.PAYMENT) {
            PaymentScreen(navController)
        }

        // Screen Regist
        composable(Routes.REGIST) {
            RegistScreen(navController = navController, authViewModel = authViewModel)
        }

        // Screen for Tests
        composable(Routes.TESTESCREEN) {
            TesteScreen(dataViewModel = dataViewModel, productViewModel = productViewModel)
        }
    }
}