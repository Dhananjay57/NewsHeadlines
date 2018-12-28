package com.news.drizzle.newsheadlines.utils

import android.databinding.BindingAdapter
import android.support.v7.widget.AppCompatImageView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.news.drizzle.newsheadlines.network.model.Article
import android.graphics.drawable.Drawable
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.news.drizzle.newsheadlines.R
import timber.log.Timber


@BindingAdapter("urlToImage")
fun setImageUrl(imageView : ImageView ,url: String) {
    Glide.with(imageView)
            .apply { RequestOptions()
                    .placeholder(R.drawable.news_logo)}
            .load(url)
            .into(imageView)
}