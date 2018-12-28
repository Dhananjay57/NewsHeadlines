package com.news.drizzle.newsheadlines.ui

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import com.news.drizzle.newsheadlines.di.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {
    @Provides
fun provideNewsAdapter():ArticlesAdapter{
        return ArticlesAdapter(ArrayList())
    }

    @Provides
fun provideLinearLayoutManager(@ApplicationContext context: Context):LinearLayoutManager{
        return LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}