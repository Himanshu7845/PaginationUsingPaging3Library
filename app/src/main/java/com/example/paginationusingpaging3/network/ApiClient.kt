/*
 * Created by : Tanishq Chawda on 3/25/23, 9:25 PM
 * Support :itanishqdeveloper@gmail.com
 * Last modified 3/25/23, 9:25 PM
 * Copyright (cart) Unorg 2023.
 * All rights reserved.
 */

package com.user.unorg.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object ApiClient {
    @Provides
    fun provideOrdersApiService(
        retrofit: Retrofit
    ): ApiRoutes {
        return retrofit.create(ApiRoutes::class.java)
    }

    @Provides
    fun provideOkHttpClient(apiKeyInterceptor: ApiKeyInterceptor): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.MINUTES) // connect timeout
            .writeTimeout(5, TimeUnit.MINUTES) // write timeout
            .readTimeout(5, TimeUnit.MINUTES)
            .addInterceptor(loggingInterceptor) /** this line comment when you publish app */
            .addInterceptor(apiKeyInterceptor)//"Authorization", Token
            .build()
    }


    @Provides
    fun provideRetrofit(loggingClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.STAGING_URL)
            .client(loggingClient)
            .build()
    }
}
