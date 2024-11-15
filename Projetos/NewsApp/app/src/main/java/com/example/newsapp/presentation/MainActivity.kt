package com.example.newsapp.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.data.repository.NewsRepositoryImpl
import com.example.newsapp.domain.use_case.GetTopStoriesUseCase
import com.example.newsapp.presentation.adapter.ArticleAdapter

class MainActivity : AppCompatActivity() {

    private val apiKey = "SUA_CHAVE_API"
    private val useCase = GetTopStoriesUseCase(NewsRepositoryImpl())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        useCase(apiKey,
            onSuccess = { articles ->
                recyclerView.adapter = ArticleAdapter(articles) { article ->
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra("URL", article.url)
                    startActivity(intent)
                }
            },
            onError = {
                Toast.makeText(this, "Erro ao carregar notícias", Toast.LENGTH_SHORT).show()
            }
        )
    }
}