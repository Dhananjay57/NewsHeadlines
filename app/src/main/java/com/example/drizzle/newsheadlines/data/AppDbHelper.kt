package com.example.drizzle.newsheadlines.data

import com.example.drizzle.newsheadlines.network.model.Article
import com.example.drizzle.newsheadlines.data.room.AppDatabase
import javax.inject.Inject

class AppDbHelper @Inject
constructor(private val appDatabase: AppDatabase): DbHelper{
    override fun insertArticles(articles: MutableList<Article>): List<Long> {
        return appDatabase.articleDao().insertArticles(articles)
    }

    override fun selectArticles(): List<Article> {
        return appDatabase.articleDao().selectArticles()
    }

    override fun deleteArticles() {
        return appDatabase.articleDao().deleteArticles()
    }

}