package com.example.newsapp.data.remote.model

import com.example.newsapp.domain.model.newstopic

data class newstopicDTO(
    val uuid : String,
    val url : String,
    val title: String,
)

{
   fun toNew():newstopic{
       return newstopic(uuid = uuid, url = url, title = title)
   }
}
