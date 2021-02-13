package com.example.nytimes.api

import com.example.nytimes.data.model.Article
import com.example.nytimes.data.remote.ArticleResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NYTimesService {

    @GET("home.json")
    suspend fun getArticles(@Query("api-key") token: String): Response<ArticleResponse<List<Article>>>
}