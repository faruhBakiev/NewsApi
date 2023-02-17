package com.excample.newsapi.data.remote.apiservices

import com.excample.newsapi.data.models.news.NewsItem
import com.excample.newsapi.data.models.news.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("everything")
    suspend fun fetchNews(
        @Query("q") query: String,
    ): NewsResponse<NewsItem>
}