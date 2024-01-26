package com.reprototyperstech.todowiz.core.repository.remote.retrofit

import com.reprototyperstech.todowiz.core.repository.remote.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakeStoreApi {
    @GET("products")
    suspend fun getProducts(): Response<List<Product>>
}