package com.example.retrofitpractice.data

import com.example.retrofitpractice.data.model.Products
import retrofit2.http.GET

interface Api {
    @GET("products")
    suspend fun getProductsLists(): Products
    companion object{
        const val BASE_URL= "https://dummyjson.com/"
    }
}