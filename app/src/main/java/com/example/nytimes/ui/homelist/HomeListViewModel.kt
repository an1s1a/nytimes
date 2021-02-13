package com.example.nytimes.ui.homelist

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.nytimes.data.model.Article
import com.example.nytimes.repositories.ArticleRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class HomeListViewModel @Inject constructor(private val articleRepository: ArticleRepository) : ViewModel() {

    private val LOG_TAG = this::class.java.simpleName

    fun getArticles() = liveData(Dispatchers.IO) {
        var retrievedArticles = articleRepository.getArticles(API_KEY)
        Log.e(LOG_TAG, "articles = $retrievedArticles")
        emit(retrievedArticles)
    }

    private val _navigateToArticleDetail = MutableLiveData<Article>()
    val navigateToArticleDetail
    get() = _navigateToArticleDetail

    fun onArticleDetailNavigated() {
        _navigateToArticleDetail.value = null
    }

    fun onArticleClicked(article: Article) {
        _navigateToArticleDetail.value = article
    }
}