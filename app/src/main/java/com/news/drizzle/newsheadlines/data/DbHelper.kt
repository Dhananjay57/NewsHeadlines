package com.news.drizzle.newsheadlines.data

import com.news.drizzle.newsheadlines.network.model.Article

interface DbHelper {
    fun insertArticles(articles: MutableList<Article>): List<Long>

    fun selectArticles(): List<Article>

    fun deleteArticles()
}