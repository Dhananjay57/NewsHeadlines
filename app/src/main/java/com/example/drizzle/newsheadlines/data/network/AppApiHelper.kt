package com.example.drizzle.newsheadlines.data.network

import com.example.drizzle.newsheadlines.data.Config
import io.reactivex.Observable
import javax.inject.Inject

class AppApiHelper @Inject constructor(private val apiService: ApiService): ApiHelper {
    override fun getArticles():Observable<Headlines?> {
        return apiService.getArticles("in", Config.API_KEY)    }


}