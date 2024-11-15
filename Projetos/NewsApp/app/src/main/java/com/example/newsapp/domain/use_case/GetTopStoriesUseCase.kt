package com.example.newsapp.domain.use_case

import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsRepository

class GetTopStoriesUseCase(private val repository: NewsRepository) {
    operator fun invoke(apiKey: String, onSuccess: (List<Article>) -> Unit, onError: (Throwable) -> Unit) {
        repository.getTopStories(apiKey, onSuccess, onError)
    }
}