package com.news.drizzle.newsheadlines.network

import com.news.drizzle.newsheadlines.network.model.Headlines
import io.reactivex.Observable


interface ApiHelper{
    fun getArticles(): Observable<Headlines?>
}

