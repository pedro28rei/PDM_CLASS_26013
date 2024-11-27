package com.example.newsapp.domain.use_case

import com.example.newsapp.domain.model.newstopic
import com.example.newsapp.domain.repository.newsrepository

class bestnewsuse_case(private val repository:newsrepository) {
    suspend operator fun invoke():List<newstopic>{
        return repository.BestNews()
    }
}