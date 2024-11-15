package com.example.newsapp.data.remote.api

import android.telecom.Call
import androidx.contentpager.content.Query
import com.example.newsapp.data.remote.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTimesApiService {
    @GET("topstories/v2/home.json")
    fun getTopStories(@Query("api-key") apiKey: String): Call<NewsResponse>
}