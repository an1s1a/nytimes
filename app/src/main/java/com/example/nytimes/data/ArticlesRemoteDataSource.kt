package com.example.nytimes.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nytimes.data.model.Article

object ArticlesRemoteDataSource : ArticleDataSource {

    private const val SERVICE_LATENCY = 2000L

    private val observableArticles = MutableLiveData<Result<List<Article>>>()

    override suspend fun getArticle(articleId: Int): Result<Article> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshArticle(articleId: Int) {
        TODO("Not yet implemented")
    }

    override fun observeArticle(articleId: Int): LiveData<Result<Article>> {
        TODO("Not yet implemented")
    }

    override suspend fun getArticles(): Result<List<Article>> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshArticles() {
        TODO("Not yet implemented")
    }

    override fun observeArticles(): LiveData<Result<List<Article>>> {
        return observableArticles
    }
}