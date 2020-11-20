package com.example.nytimes.api

import retrofit2.http.GET
import retrofit2.http.Header

interface NYTimesService {

    @GET("home.json")
    suspend fun getArticles(@Header("api-key") token : String)
}