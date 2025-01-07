package com.example.shoppingapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.shoppingapp.presentation.viewmodels.DataViewModel

@Composable
fun listUsersScreen(dataViewModel: DataViewModel) {

    val getData = dataViewModel.state.value

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = getData.name)
        Text(text = getData.email)
        Text(text = getData.password)
        Text(text = getData.password)
    }
}