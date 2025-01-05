package com.example.shoppingapp.backend.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppingapp.backend.models.Product
import com.example.shoppingapp.backend.firebase.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    // Carrega todos os produtos
    fun loadProducts() {
        viewModelScope.launch {
            try {
                val productList = repository.getAllProducts()
                _products.value = productList
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    // Adiciona ou atualiza um produto
    fun saveProduct(product: Product) {
        viewModelScope.launch {
            try {
                repository.saveProduct(product)
                loadProducts() // Atualiza lista após salvar
            } catch (e: Exception) {
                // Lidar com erro
                e.printStackTrace()
            }
        }
    }

    // Remove um produto
    fun deleteProduct(productID: String) {
        viewModelScope.launch {
            try {
                repository.deleteProduct(productID)
                loadProducts() // Atualiza lista após remover
            } catch (e: Exception) {
                // Lidar com erro
                e.printStackTrace()
            }
        }
    }
}
