package com.example.newsapp.domain.repository

import com.example.newsapp.domain.model.newstopic

interface newsrepository {
    suspend fun BestNews():List<newstopic>
}