package com.example.shoppingapp.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.shoppingapp.presentation.components.CustomButton
import com.example.shoppingapp.presentation.navigation.Routes
import com.example.shoppingapp.R
import com.example.shoppingapp.presentation.viewmodels.AuthState
import com.example.shoppingapp.presentation.viewmodels.AuthViewModel


// Start screen of app
@Composable
fun StartScreen(modifier: Modifier = Modifier, authViewModel: AuthViewModel, navController: NavHostController) {

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated -> navController.navigate(Routes.HOME)
            is AuthState.Error -> Toast.makeText(context, (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Upper half of screen
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)
        ) {
            // Logo of App
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Top Image",
                modifier = Modifier.fillMaxSize()
            )
        }

        // Lower half of the screen
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
                .align(Alignment.BottomCenter)
                .background(Color.Red)
        ) {

            // Button for user navigate to Login screen
            CustomButton(
                label = "LOGIN",
                color = Color.Black,
                onClick = {
                    navController.navigate(Routes.LOGIN) },
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 40.dp)
            )

            // Clickable Text for User navigate to Home screen without login done
            Text(
                text = "Continue without account",
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                ),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 65.dp)
                    .clickable { //navController.navigate(Routes.HOME)
                         }
            )

        }
    }
}