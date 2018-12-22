package com.example.drizzle.newsheadlines.data.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.drizzle.newsheadlines.network.model.Article

@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase(){
    abstract fun articleDao() : ArticleDao

}