package com.example.calculadora.ui

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(label: String, onClick: (String) -> Unit) {

    Button(onClick = { onClick(label) },) {
        Text(text = label, fontSize = 24.sp)
    }
}