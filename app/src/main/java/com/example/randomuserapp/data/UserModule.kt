package com.example.randomuserapp.data

import com.example.randomuserapp.data.remote.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class UserModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Singleton
    @Provides
    fun providePreferencesApiClient(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}
