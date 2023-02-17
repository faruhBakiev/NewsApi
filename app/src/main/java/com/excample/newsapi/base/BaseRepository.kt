package com.excample.newsapi.base

import androidx.lifecycle.liveData
import com.excample.newsapi.utils.Resource

abstract class BaseRepository {

    protected open fun<T> doRequest(request: suspend () -> T) = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(request()))
        } catch (ioException: Exception) {
            emit(Resource.Error( ioException.localizedMessage ?: "Error"))
        }
    }
}