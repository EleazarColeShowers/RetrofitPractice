package com.example.retrofitpractice.data

import com.example.retrofitpractice.data.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

//pass an instance of api and inherit the repository
class ProductsRepositoryImpl (
    val api: Api
): ProductsRepository{
    override suspend fun getProductList(): Flow<Result<List<Product>>> {
        return flow {
            //fetch products from api
            val productsFromApi= try {
                api.getProductsLists()
            }catch (e:Exception){
                e.printStackTrace()
                emit(Result.Error(message = "Error Loading Products"))
                return@flow
            }
            emit(Result.Success(productsFromApi.products))
        }
    }
}