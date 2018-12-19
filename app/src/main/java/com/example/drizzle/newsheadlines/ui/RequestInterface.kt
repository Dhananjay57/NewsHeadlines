package com.example.drizzle.newsheadlines.ui

import io.reactivex.Observable
import retrofit2.http.GET

interface RequestInterface {
    @GET("api/android")
    fun getData():Observable<List<Item>>
}