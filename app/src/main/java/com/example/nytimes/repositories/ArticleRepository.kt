package com.example.nytimes.repositories

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepository @Inject constructor(private val remoteDataSource: ArticleRemoteDataSource) {

    suspend fun getArticles(token: String) = remoteDataSource.getArticles(token)
}