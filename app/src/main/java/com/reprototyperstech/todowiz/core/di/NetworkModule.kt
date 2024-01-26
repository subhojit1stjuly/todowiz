package com.reprototyperstech.todowiz.core.di

import com.reprototyperstech.todowiz.core.repository.remote.retrofit.FakeStoreApi
import com.reprototyperstech.todowiz.core.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Singleton
    @Provides
    fun provideFakeStoreApi(retrofit: Retrofit):FakeStoreApi{
        return retrofit.create(FakeStoreApi::class.java)
    }
}
