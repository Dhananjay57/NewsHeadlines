package com.example.drizzle.newsheadlines.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.drizzle.newsheadlines.network.model.Article
import com.example.drizzle.newsheadlines.databinding.NewsArticleListItemBinding

class ArticlesAdapter(private val  articles: MutableList<Article>?) : RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>() {

    interface Callback {
        fun onArticleClick(url: String)
    }

    private var callback: Callback? = null

    fun setCallback(callback: Callback) {
        this.callback = callback
    }

    fun addItems(articles: MutableList<Article>?) {
        this.articles?.clear()
        articles?.let { this.articles?.addAll(it) }
        notifyDataSetChanged()
    }

    private fun getItem(position: Int): Article? {
        return if (position != RecyclerView.NO_POSITION) {
            articles?.get(position)
        } else
            null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val binding = NewsArticleListItemBinding.inflate(inflater)
        return ArticleViewHolder(binding)
    }

    override fun getItemCount(): Int = articles?.size!!

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int)= holder.bind(articles?.get(position)!!)
    inner class ArticleViewHolder (val binding: NewsArticleListItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: Article){
            binding.articles = item
            binding.executePendingBindings()
        }
    }



}