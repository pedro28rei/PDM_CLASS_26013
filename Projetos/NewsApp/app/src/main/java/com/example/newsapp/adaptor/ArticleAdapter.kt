package com.example.newsapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.domain.model.Article
import kotlinx.android.synthetic.main.item_article.view.*

class ArticleAdapter(
    private val articles: List<Article>,
    private val onClick: (Article) -> Unit
) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articles[position], onClick)
    }

    override fun getItemCount(): Int = articles.size

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(article: Article, onClick: (Article) -> Unit) {
            itemView.titleTextView.text = article.title
            itemView.abstractTextView.text = article.abstract
            Glide.with(itemView).load(article.imageUrl).into(itemView.imageView)
            itemView.setOnClickListener { onClick(article) }
        }
    }
}