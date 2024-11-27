package com.example.newsapp.presentation.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.view_models.bestnewsViewModel

@Composable
fun bestnewsScreen(viewModel: bestnewsViewModel){

    LaunchedEffect(Unit) {
        viewModel.searchnews()
    }

    val news by viewModel.news.collectAsState()

    Box(modifier = Modifier
        .fillMaxSize()){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            items(news) { item ->
                Box(
                    modifier = Modifier
                        .width(250.dp)
                        .padding(bottom = 10.dp)
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(8.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CreateText(item.title,Modifier.fillMaxWidth(),Color.Black,
                            textAlign = TextAlign.Center, 16.sp)
                        TextButton(
                            onClick = {
                            }){
                            Text("Details")
                        }
                    }
                }
            }
        }
        Button(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.BottomCenter),
            onClick = {},

            ){
            Text("Go back")
        }
    }
}

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