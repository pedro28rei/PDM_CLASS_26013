package com.example.newsapp.data.repository

import com.example.newsapp.data.remote.api.NewsApi
import com.example.newsapp.domain.model.newstopic
import com.example.newsapp.domain.repository.newsrepository

class newsrepositoryIMPL(private val api: NewsApi):newsrepository {
    override suspend fun BestNews(): List<newstopic> {
        return api.BestNews().data.map{
            it.toNew()
        }
    }

}