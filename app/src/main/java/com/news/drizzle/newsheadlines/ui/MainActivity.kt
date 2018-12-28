package com.news.drizzle.newsheadlines.ui

import android.arch.lifecycle.ViewModelProviders
import android.support.customtabs.CustomTabsIntent
import android.databinding.DataBindingUtil
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.news.drizzle.newsheadlines.R
import com.news.drizzle.newsheadlines.ViewModelFactory
import com.news.drizzle.newsheadlines.data.DataManager
import com.news.drizzle.newsheadlines.network.model.Article
import com.news.drizzle.newsheadlines.network.model.Headlines
import com.news.drizzle.newsheadlines.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.Observer
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() , ArticlesAdapter.Callback{

    @Inject
    lateinit var mCompositeDisposable : CompositeDisposable
    lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var dataManager:DataManager

    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager
    @Inject
    lateinit var customTabIntent: CustomTabsIntent
    @Inject
    lateinit var adapter: ArticlesAdapter
    private lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        newsViewModel = ViewModelProviders.of(
                this, ViewModelFactory.getInstance(application, dataManager)
        ).get(NewsViewModel::class.java)
        adapter.setCallback(this)
        init()
    }

    private fun init() {
       setSupportActionBar(toolbar as Toolbar?)
        refresh_layout.setOnRefreshListener {
            newsViewModel.getArticlesFromNetwork()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(object :Observer<Headlines?>{
                        override fun onComplete() {
                            refresh_layout.isRefreshing = false
                        }

                        override fun onSubscribe(d: Disposable) {
                            refresh_layout.isRefreshing = true
                            mCompositeDisposable.add(d)
                        }

                        override fun onNext(t: Headlines) {
                            adapter.addItems(t.articles as MutableList<Article>?)
                            Timber.d(t.toString())
                        }

                        override fun onError(e: Throwable) {
                            refresh_layout.isRefreshing = false
                            Timber.e(e.message)
                        }
                    })

        }
        news_recyclerView.layoutManager = linearLayoutManager
        news_recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        news_recyclerView.adapter = adapter

        getArticles()


    }

    private fun getArticles() {
        Observable.concat(
                newsViewModel.getArticlesFromDatabase(),
                newsViewModel.getArticlesFromNetwork()
        )
                .observeOn(AndroidSchedulers.mainThread(), true)
                .subscribe(object : Observer<Headlines?> {
                    override fun onComplete() {
                        refresh_layout.isRefreshing = false
                    }

                    override fun onSubscribe(d: Disposable) {
                        refresh_layout.isRefreshing = true
                        mCompositeDisposable.add(d)
                    }

                    override fun onNext(t: Headlines) {
                        adapter.addItems(t.articles as MutableList<Article>?)
                    }

                    override fun onError(e: Throwable) {
                        refresh_layout.isRefreshing = false
                        Timber.e(e.message)
                    }
                })
    }

    override fun onArticleClick(url: String) {
        customTabIntent.launchUrl(this, Uri.parse(url))
    }

    override fun onDestroy() {
        mCompositeDisposable?.clear()
        super.onDestroy()
    }
}
