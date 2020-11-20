package com.example.nytimes.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nytimes.data.model.Article

@Dao
interface ArticleDao {

    @Query("SELECT * FROM article")
    fun getArticles(): LiveData<List<Article>>

    @Query("SELECT * FROM article WHERE id = :id")
    fun getArticle(id: Int): LiveData<Article>

    @Query("SELECT * FROM article WHERE favorite IS 'TRUE'")
    fun getFavoriteArticles(): LiveData<List<Article>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(articles: List<Article>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)
}