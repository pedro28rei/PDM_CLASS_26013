package com.example.newsapp.domain.model

data class newsinfo(
    val uuid : String,
    val url : String,
    val title: String,
    val description: String,
    val keywords: String,
    val image_url : String,
    val language : String,
    val published_at : String,
    val source: String,
    val categories: List<String>
)
