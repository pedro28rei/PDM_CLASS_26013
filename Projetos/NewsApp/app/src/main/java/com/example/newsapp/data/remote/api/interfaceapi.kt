package com.example.newsapp.data.remote.api

import com.example.newsapp.data.remote.model.dataresponse
import retrofit2.http.GET

interface NewsApi {
    @GET("top?api_token=pTktYa7eB1h8ZCE4NvvuEwrpFhcA78sgXc9FFl4q")
    suspend fun BestNews(): dataresponse
}

//pTktYa7eB1h8ZCE4NvvuEwrpFhcA78sgXc9FFl4q