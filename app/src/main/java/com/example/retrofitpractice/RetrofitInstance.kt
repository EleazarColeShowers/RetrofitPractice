package com.example.retrofitpractice

import com.example.retrofitpractice.data.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    //create an HTTPLoginInterceptor to log what we're doing
    private val interceptor : HttpLoggingInterceptor= HttpLoggingInterceptor().apply {
        level= HttpLoggingInterceptor.Level.BODY
    }

    //Create an OkhttpClient
    private val client: OkHttpClient =OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    //Create an API instance
    val api: Api = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Api.BASE_URL)
        .client(client)
        .build()
        .create(Api::class.java)
}