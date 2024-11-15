package com.example.newsapp.domain.model

data class Article(
    val title: String,
    val abstract: String,
    val url: String,
    val imageUrl: String?
)