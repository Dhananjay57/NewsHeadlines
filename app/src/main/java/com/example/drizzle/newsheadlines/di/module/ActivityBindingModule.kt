package com.example.drizzle.newsheadlines.di.module

import com.example.drizzle.newsheadlines.ui.MainActivity
import com.example.drizzle.newsheadlines.ui.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity():MainActivity
}