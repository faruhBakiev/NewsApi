package com.excample.newsapi.ui.fragments.everything

import com.excample.newsapi.base.BaseViewModel
import com.excample.newsapi.data.repositories.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EverythingViewModel @Inject constructor(private val repository: NewsRepository) :
    BaseViewModel() {

    fun fetchNews(q: String) = repository.fetchNews(q)
}