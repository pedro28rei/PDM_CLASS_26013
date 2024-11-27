package com.example.newsapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class dataresponse(
    @SerializedName("data")
    val data: List<newstopicDTO>,

)