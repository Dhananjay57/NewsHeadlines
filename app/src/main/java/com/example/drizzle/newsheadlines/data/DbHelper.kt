package com.example.drizzle.newsheadlines.data

import com.example.drizzle.newsheadlines.network.model.Article

interface DbHelper {
    fun insertArticles(articles: MutableList<Article>): List<Long>

    fun selectArticles(): List<Article>

    fun deleteArticles()
}