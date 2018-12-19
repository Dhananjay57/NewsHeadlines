package com.example.drizzle.newsheadlines.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Source(

        @SerializedName("id")
        @Expose
        var id: Any? = null,
        @SerializedName("name")
        @Expose
        var name: String? = null

)
