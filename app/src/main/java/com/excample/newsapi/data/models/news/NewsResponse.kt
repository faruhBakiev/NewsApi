package com.excample.newsapi.data.models.news

import com.google.gson.annotations.SerializedName

data class NewsResponse<T>(
    @SerializedName("totalResults")
    val totalResults: Int = 0,
    @SerializedName("articles")
    val articles: List<T>,
    @SerializedName("status")
    val status: String = ""

)