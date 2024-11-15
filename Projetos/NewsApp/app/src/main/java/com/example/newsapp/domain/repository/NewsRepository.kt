package com.example.newsapp.domain.repository

import com.example.newsapp.domain.model.Article

interface NewsRepository {
    fun getTopStories(apiKey: String, onSuccess: (List<Article>) -> Unit, onError: (Throwable) -> Unit)
}
