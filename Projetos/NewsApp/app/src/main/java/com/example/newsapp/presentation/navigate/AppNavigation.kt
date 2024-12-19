package com.example.newsapp.presentation.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.presentation.navigate.Routes

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {


    NavHost(
        navController = navController,
        startDestination = Routes.BESTNEWS
    ) {

        composable(Routes.BESTNEWS) {
        }

        // Screen of the News Details
        composable(Routes.NEWSDETAILS) {
        }
    }
}