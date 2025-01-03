package com.example.shoppingapp.presentation.screens


import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shoppingapp.presentation.components.CustomButton
import com.example.shoppingapp.presentation.navigation.Routes
import com.example.shoppingapp.ui.theme.LightBlue

@Composable
fun StartScreen(navController: NavController) {

    CustomButton(
        label = "LOGIN",
        color = LightBlue,
        onClick = {navController.navigate(Routes.LOGIN)}, // navigate to login screen
        modifier = Modifier
            .padding(top = 130.dp)
    )


}