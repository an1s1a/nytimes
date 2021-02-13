package com.example.nytimes.repositories

import com.example.nytimes.api.BaseDataSource
import com.example.nytimes.api.NYTimesService
import javax.inject.Inject

class ArticleRemoteDataSource @Inject constructor(private val service: NYTimesService) : BaseDataSource() {

    suspend fun getArticles(token: String) = getResult {
        service.getArticles(token) }
}