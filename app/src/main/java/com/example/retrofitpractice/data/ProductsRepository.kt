package com.example.retrofitpractice.data

import com.example.retrofitpractice.data.model.Product
import com.example.retrofitpractice.data.model.Products
import kotlinx.coroutines.flow.Flow

//to get the products
interface ProductsRepository {
    suspend fun getProductList(): Flow<Result<List<Product>>>
}