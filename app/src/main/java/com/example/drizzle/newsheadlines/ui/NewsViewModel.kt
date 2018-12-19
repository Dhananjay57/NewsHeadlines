package com.example.drizzle.newsheadlines.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel
import android.content.Context
import com.example.drizzle.newsheadlines.data.DataManager
import com.example.drizzle.newsheadlines.data.network.Article
import com.example.drizzle.newsheadlines.data.network.Headlines
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class NewsViewModel(
        context: Application,
        private val dataManager: DataManager): AndroidViewModel(context) {

    fun getArticlesFromNetwork(): Observable<Headlines?> {
        return dataManager.getArticles()
                .map { it: Headlines? ->
                    if (it?.articles != null) {
                        dataManager.deleteArticles()
                        dataManager.insertArticles(it.articles as MutableList<Article>)
                    }
                    it
                }
                .subscribeOn(Schedulers.io())
    }
}