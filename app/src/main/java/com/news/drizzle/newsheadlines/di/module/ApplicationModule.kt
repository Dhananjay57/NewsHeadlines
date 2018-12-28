package com.news.drizzle.newsheadlines.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat
import com.news.drizzle.newsheadlines.NewsHeadlineApplication
import com.news.drizzle.newsheadlines.R
import com.news.drizzle.newsheadlines.data.*
import com.news.drizzle.newsheadlines.data.room.AppDatabase
import com.news.drizzle.newsheadlines.network.ApiHelper
import com.news.drizzle.newsheadlines.network.AppApiHelper
import com.news.drizzle.newsheadlines.di.ApplicationContext
import com.news.drizzle.newsheadlines.di.BaseUrl
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
    fun provideRoomDatabase(@ApplicationContext context: Context):AppDatabase{
        return Room.databaseBuilder(context, AppDatabase::class.java, Config.DB_NAME)
                .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
                .build()
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    internal fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper {
        return appDbHelper
    }

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper):ApiHelper{
        return appApiHelper
    }
}