package com.example.drizzle.newsheadlines.di.module

import android.app.Application
import android.content.Context
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat
import com.example.drizzle.newsheadlines.NewsHeadlineApplication
import com.example.drizzle.newsheadlines.R
import com.example.drizzle.newsheadlines.data.AppDataManager
import com.example.drizzle.newsheadlines.data.Config
import com.example.drizzle.newsheadlines.data.DataManager
import com.example.drizzle.newsheadlines.di.ApplicationContext
import com.example.drizzle.newsheadlines.di.BaseUrl
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule {
    @Provides
    @ApplicationContext
    internal fun provideContext(newsHeadlineApplication: NewsHeadlineApplication): Context {
        return newsHeadlineApplication.applicationContext
    }

    @Provides
    internal fun provideApplication(newsHeadlineApplication: NewsHeadlineApplication): Application {
        return newsHeadlineApplication
    }

    @Provides
    @BaseUrl
    internal fun provideBaseUrl(): String {
        return Config.BASE_URL
    }

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    fun provideCustomTabsIntent(@ApplicationContext context: Context): CustomTabsIntent {
        return CustomTabsIntent.Builder()
                .setShowTitle(true)
                .setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary))
                .setSecondaryToolbarColor(ContextCompat.getColor(context, R.color.colorPrimaryDark))
                .addDefaultShareMenuItem()
                .build()
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager):DataManager{
        return appDataManager
    }
}