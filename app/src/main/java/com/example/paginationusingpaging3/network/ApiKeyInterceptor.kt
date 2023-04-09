package com.user.unorg.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class ApiKeyInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val value = originalRequest.url
        val requestBuilder = chain.request().newBuilder()
        Log.d("valuePath", "intercept: ${value.encodedPath}")
        if (value.encodedPath.contains("userapp-items")) {
            requestBuilder.addHeader("Authorization", Constants.token!!)
            requestBuilder.addHeader("user-id", Constants.userId!!)
            requestBuilder.addHeader("Content-Type", "application/json")
        }
        return chain.proceed(requestBuilder.build())
    }

}