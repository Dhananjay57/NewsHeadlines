package com.news.drizzle.newsheadlines.data

import com.news.drizzle.newsheadlines.network.AppApiHelper
import com.news.drizzle.newsheadlines.network.model.Article
import com.news.drizzle.newsheadlines.network.model.Headlines
import io.reactivex.Observable
import javax.inject.Inject

class AppDataManager @Inject constructor(private val appApiHelper: AppApiHelper, private val appDbHelper: AppDbHelper) : DataManager {

    override fun getArticles(): Observable<Headlines?> {
        return appApiHelper.getArticles()
    }

    override fun insertArticles(articles: MutableList<Article>): List<Long> {
        return appDbHelper.insertArticles(articles)
    }

    override fun selectArticles(): List<Article> {
        return appDbHelper.selectArticles()
    }

    override fun deleteArticles() {
        appDbHelper.deleteArticles()
    }

}