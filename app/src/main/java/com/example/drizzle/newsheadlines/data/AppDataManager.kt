package com.example.drizzle.newsheadlines.data

import com.example.drizzle.newsheadlines.data.network.AppApiHelper
import com.example.drizzle.newsheadlines.data.network.Article
import com.example.drizzle.newsheadlines.data.network.Headlines
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

class AppDataManager @Inject constructor(private val appApiHelper: AppApiHelper/*, private val appDbHelper: AppDbHelper*/) : DataManager {

    override fun getArticles(): Observable<Headlines?> {
        return appApiHelper.getArticles()
    }

    override fun insertArticles(articles: MutableList<Article>): List<Long> {
       // return appDbHelper.insertArticles(articles)
        return ArrayList<Long>()
    }

    override fun selectArticles(): List<Article> {
        //return appDbHelper.selectArticles()

        return ArrayList<Article>()
    }

    override fun deleteArticles() {
        //appDbHelper.deleteArticles()

    }

}