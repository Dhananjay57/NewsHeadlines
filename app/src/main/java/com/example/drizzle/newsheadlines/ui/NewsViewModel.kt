package com.example.drizzle.newsheadlines.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.example.drizzle.newsheadlines.data.DataManager
import com.example.drizzle.newsheadlines.network.model.Article
import com.example.drizzle.newsheadlines.network.model.Headlines
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

    fun getArticlesFromDatabase():Observable<Headlines?>{
        return Observable.defer { Observable.just(dataManager.selectArticles()) }
                .map { item:List<Article>->
                    val headlines:Headlines? = Headlines(
                            "ok",20, item)
                    headlines

                }
                .subscribeOn(Schedulers.computation())
    }

}