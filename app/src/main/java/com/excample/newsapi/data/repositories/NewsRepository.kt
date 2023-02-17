package com.excample.newsapi.data.repositories

import com.excample.newsapi.base.BaseRepository
import com.excample.newsapi.data.remote.apiservices.NewsApiService
import javax.inject.Inject

class NewsRepository @Inject constructor(private val services: NewsApiService) :
    BaseRepository() {

    fun fetchNews(q: String) = doRequest {
        services.fetchNews(q)
    }
}

