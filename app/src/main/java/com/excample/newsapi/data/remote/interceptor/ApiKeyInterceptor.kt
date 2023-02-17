package com.excample.newsapi.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder().addQueryParameter("apiKey","3e0583dabb334edfb6dd7d7662748de7").build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}