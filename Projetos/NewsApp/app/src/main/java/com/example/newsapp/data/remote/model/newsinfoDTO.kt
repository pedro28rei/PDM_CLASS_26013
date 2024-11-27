package com.example.newsapp.data.remote.model

import com.example.newsapp.domain.model.newsinfo
import com.example.newsapp.domain.model.newstopic

data class newsinfoDTO(
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

{
    fun toNew(): newsinfo {
        return newsinfo(uuid = uuid, url = url, title = title, description = description, keywords = keywords, image_url= image_url,
            language = language, published_at=published_at, source=source, categories=categories)
    }
}