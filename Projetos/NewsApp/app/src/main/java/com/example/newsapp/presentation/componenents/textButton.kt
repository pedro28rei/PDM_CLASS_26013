package com.example.newsapp.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit

@Composable
fun CreateText(string:String, modifier: Modifier, color: Color, textAlign: TextAlign, size: TextUnit){
    Text(
        text = string,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        fontSize = size,
    )
}