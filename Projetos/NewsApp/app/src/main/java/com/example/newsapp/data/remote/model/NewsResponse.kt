package com.example.newsapp.data.remote.model

data class NewsResponse(
    val status: String,
    val results: List<ArticleResponse>
)

data class ArticleResponse(
    val title: String,
    val abstract: String,
    val url: String,
    val multimedia: List<MediaResponse>?
)

data class MediaResponse(
    val url: String
)
