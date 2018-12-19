package com.example.drizzle.newsheadlines.data.network

import com.example.drizzle.newsheadlines.data.network.Headlines
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    fun getArticles(
            @Query("country") country: String,
            @Query("apiKey") apiKey: String
    ): Observable<Headlines?>
}