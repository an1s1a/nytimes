package com.example.nytimes.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Article (
    @PrimaryKey
    val id: Int,
    val title: String,
    val section: String,
    val subsection: String,
    val abstract: String,
    val published_date: String,
    val favorite: Boolean
)