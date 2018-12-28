package com.news.drizzle.newsheadlines.di.component

import com.news.drizzle.newsheadlines.NewsHeadlineApplication
import com.news.drizzle.newsheadlines.di.module.ActivityBindingModule
import com.news.drizzle.newsheadlines.di.module.ApplicationModule
import com.news.drizzle.newsheadlines.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class,
    NetworkModule::class,
    ApplicationModule::class

])
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(newsHeadlineApplication: NewsHeadlineApplication): Builder

        fun build(): ApplicationComponent
    }

    fun inject(newsHeadlineApplication: NewsHeadlineApplication)
}