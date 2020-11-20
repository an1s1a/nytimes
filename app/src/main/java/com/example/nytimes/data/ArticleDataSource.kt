package com.example.nytimes.data

import androidx.lifecycle.LiveData
import com.example.nytimes.data.model.Article

interface ArticleDataSource {

    suspend fun getArticle(articleId: Int): Result<Article>

    suspend fun refreshArticle(articleId: Int)

    fun observeArticle(articleId: Int): LiveData<Result<Article>>

    suspend fun getArticles(): Result<List<Article>>

    suspend fun refreshArticles()

    fun observeArticles(): LiveData<Result<List<Article>>>
}