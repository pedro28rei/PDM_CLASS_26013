package com.example.newsapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.components.CreateText
import com.example.newsapp.presentation.view_models.bestnewsViewModel

@Composable
fun BestnewsScreen(viewModel: bestnewsViewModel) {
    LaunchedEffect(Unit) {
        viewModel.searchnews()
    }

    val news by viewModel.news.collectAsState()


    Column(
        modifier = Modifier.background(Color(0xFFB2F5A5))
    ) {
        // Box with title of Screen
        Column(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Box(
                modifier = Modifier
                    .padding(top = 110.dp)
                    .height(80.dp)
                    .width(300.dp)
                    .border(
                        width = 2.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .background(Color.Black)
            ) {
                Text(
                    text = "BEST NEWS",
                    modifier = Modifier
                        .padding(top = 25.dp)
                        .fillMaxWidth(),
                    color = Color.White,
                    fontSize = 27.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Column(
            modifier = Modifier
                .padding(17.dp)
                .padding(top = 20.dp)
        ) {

            // News Listed with a own box for each other
            Box(modifier = Modifier.weight(1f)) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    items(news) { item ->
                        Box(
                            modifier = Modifier
                                .width(400.dp)
                                .padding(bottom = 10.dp)
                                .border(
                                    width = 1.5.dp,
                                    color = Color.Gray,
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .padding(8.dp)
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                CreateText(
                                    item.title,
                                    Modifier.fillMaxWidth(),
                                    Color.Black,
                                    textAlign = TextAlign.Center,
                                    size = 16.sp
                                )
                                TextButton(
                                    onClick = {
                                    }) {
                                    Text(
                                        text = "More Details",
                                        fontWeight = FontWeight.Bold,
                                        textDecoration = TextDecoration.Underline
                                    )
                                }
                            }
                        }
                    }
                }
            }
            // Button to go to page before
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 130.dp),
                onClick = {}
            ) {
                Text(
                    text = "GO BACK",
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
            }
        }
    }
}