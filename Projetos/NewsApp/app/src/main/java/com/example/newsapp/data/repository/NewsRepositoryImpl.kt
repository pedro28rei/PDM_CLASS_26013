package com.example.newsapp.data.repository

import com.example.newsapp.data.remote.api.RetrofitInstance
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsRepository

class NewsRepositoryImpl : NewsRepository {
    override fun getTopStories(apiKey: String, onSuccess: (List<Article>) -> Unit, onError: (Throwable) -> Unit) {
        RetrofitInstance.api.getTopStories(apiKey).enqueue(object : retrofit2.Callback<com.example.newsapp.data.remote.model.NewsResponse> {
            override fun onResponse(
                call: retrofit2.Call<com.example.newsapp.data.remote.model.NewsResponse>,
                response: retrofit2.Response<com.example.newsapp.data.remote.model.NewsResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val articles = response.body()!!.results.map { articleResponse ->
                        Article(
                            title = articleResponse.title,
                            abstract = articleResponse.abstract,
                            url = articleResponse.url,
                            imageUrl = articleResponse.multimedia?.firstOrNull()?.url
                        )
                    }
                    onSuccess(articles)
                } else {
                    onError(Throwable("Failed to fetch data"))
                }
            }

            override fun onFailure(call: retrofit2.Call<com.example.newsapp.data.remote.model.NewsResponse>, t: Throwable) {
                onError(t)
            }
        })
    }
}
