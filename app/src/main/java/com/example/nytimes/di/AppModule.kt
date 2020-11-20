package com.example.nytimes.di

import android.content.Context
import com.example.nytimes.NYTApplication
import com.example.nytimes.annotations.CoroutineScopeIO
import com.example.nytimes.api.NYTimesService
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: NYTApplication): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.nytimes.com/svc/topstories/v2/")
            .build()
    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): NYTimesService {
        return retrofit.create(NYTimesService::class.java)
    }

    @CoroutineScopeIO
    @Provides
    fun provideCoroutineScope() = CoroutineScope(Dispatchers.IO)
}