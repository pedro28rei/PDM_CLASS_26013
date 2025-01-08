package com.example.shoppingapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppingapp.firebase.models.Product
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class ProductViewModel : ViewModel() {
    // MutableStateFlow para armazenar o estado dos produtos
    private val _state = MutableStateFlow<List<Product>>(emptyList())
    val state: StateFlow<List<Product>> = _state

    init {
        getProducts() // Carregar os produtos na inicialização
    }

    private fun getProducts() {
        viewModelScope.launch {
            val products = fetchProductsFromFirestore()
            _state.value = products
        }
    }

    private suspend fun fetchProductsFromFirestore(): List<Product> {
        val db = FirebaseFirestore.getInstance()
        val productList = mutableListOf<Product>()

        try {
            val querySnapshot = db.collection("Product").get().await()
            for (document in querySnapshot) {
                val product = document.toObject(Product::class.java)
                productList.add(product)
            }
        } catch (e: Exception) {
            // Handle error
        }
        return productList
    }
}

