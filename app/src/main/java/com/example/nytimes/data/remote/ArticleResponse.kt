package com.example.nytimes.data.remote

import com.example.nytimes.data.model.Article

data class ArticleResponse<T>(
    val status: String,
    val results: List<Article>
)