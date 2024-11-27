package com.example.newsapp.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.remote.api.RetrofitInstance
import com.example.newsapp.data.repository.newsrepositoryIMPL
import com.example.newsapp.domain.model.newstopic
import com.example.newsapp.domain.use_case.bestnewsuse_case
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class bestnewsViewModel:ViewModel() {
    private val api = RetrofitInstance.api
    private val repository = newsrepositoryIMPL(api)
    private val bestnewsuseCase = bestnewsuse_case(repository)

    val news = MutableStateFlow<List<newstopic>>(emptyList())

    fun searchnews(){
        viewModelScope.launch {
            try {
                news.value = bestnewsuseCase()
            }

            catch (e:Exception) { news.value = emptyList()
            }

        }
    }
}