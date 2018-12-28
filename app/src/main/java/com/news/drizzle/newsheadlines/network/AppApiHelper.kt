package com.news.drizzle.newsheadlines.network

import com.news.drizzle.newsheadlines.data.Config
import com.news.drizzle.newsheadlines.network.model.Headlines
import io.reactivex.Observable
import javax.inject.Inject

class AppApiHelper @Inject constructor(private val apiService: ApiService): ApiHelper {
    override fun getArticles():Observable<Headlines?> {
        return apiService.getArticles("in", Config.API_KEY)    }


}