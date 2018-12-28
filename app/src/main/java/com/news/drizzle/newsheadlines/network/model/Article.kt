package com.news.drizzle.newsheadlines.network.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.news.drizzle.newsheadlines.data.room.Converters
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "articles")
@TypeConverters(Converters::class)
data class Article(
        @PrimaryKey(autoGenerate = true)
        var id: Long,

        @SerializedName("source")
        @Expose
        @ColumnInfo(name = "source")
        var source: Source? = null,

        @SerializedName("author")
        @Expose
        @ColumnInfo(name = "author")
        var author: String? = null,

        @SerializedName("title")
        @Expose
        @ColumnInfo(name = "title")
        var title: String? = null,

        @SerializedName("description")
        @Expose
        @ColumnInfo(name = "description")
        var description: String? = null,

        @SerializedName("url")
        @Expose
        @ColumnInfo(name = "url")
        var url: String? = null,

        @SerializedName("urlToImage")
        @Expose
        @ColumnInfo(name = "urlToImage")
        var urlToImage: String? = null,

        @SerializedName("publishedAt")
        @Expose
        @ColumnInfo(name = "publishedAt")
        var publishedAt: String? = null
)
