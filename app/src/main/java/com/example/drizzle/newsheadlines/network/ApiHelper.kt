package com.example.drizzle.newsheadlines.network

import com.example.drizzle.newsheadlines.network.model.Headlines
import io.reactivex.Observable


interface ApiHelper{
    fun getArticles(): Observable<Headlines?>
}

