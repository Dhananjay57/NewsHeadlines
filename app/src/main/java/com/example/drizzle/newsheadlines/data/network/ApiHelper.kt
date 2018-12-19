package com.example.drizzle.newsheadlines.data.network

import io.reactivex.Observable


interface ApiHelper{
    fun getArticles(): Observable<Headlines?>
}

