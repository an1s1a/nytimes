package com.example.nytimes.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.nytimes.data.model.Article

@BindingAdapter("articleImage")
fun ImageView.setArticleImage(article: Article) {
    article.multimedia[2].url.let {
        Glide
            .with(this.context)
            .load(it)
            .into(this)
    }
}