package com.example.shoppingapp.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppingapp.firebase.models.Product
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

// ViewModel responsible for fetching and managing product data.
class ProductViewModel : ViewModel() {

    // State to hold the list of products fetched from Firestore.
    val state = mutableStateOf<List<Product>>(emptyList())

    val loading = mutableStateOf(false)
    val error = mutableStateOf<String?>(null)

    // Initialization block to fetch product data when the ViewModel is created.
    init {
        getProductsData()  // Calls the function to fetch products from Firestore
    }


    // Function that fetches product data from Firestore asynchronously.
    private fun getProductsData() {
        viewModelScope.launch {
            loading.value = true
            try {
                state.value = getProductsFromFireStore()
            } catch (e: Exception) {
                error.value = e.message
            } finally {
                loading.value = false
            }
        }
    }

    // Function to add a new product to Firestore.
    fun addProduct(product: Product) {
        viewModelScope.launch {
            try {
                val db = FirebaseFirestore.getInstance()
                val productRef = db.collection("Product").document()  // Auto-generate the document ID
                productRef.set(product).await()
                getProductsData()
            } catch (e: Exception) {
                error.value = e.message
                Log.d("error", "addProduct: $e")
            }
        }
    }

    // Function to remove a product from Firestore by productID.
    fun removeProduct(productID: String) {
        viewModelScope.launch {
            try {
                val db = FirebaseFirestore.getInstance()
                val productRef = db.collection("Product").document(productID)
                productRef.delete().await()
                getProductsData()
            } catch (e: Exception) {
                error.value = e.message
                Log.d("error", "removeProduct: $e")
            }
        }
    }

    // Function to edit an existing product in Firestore by productID.
    fun editProduct(productID: String, updatedProduct: Product) {
        viewModelScope.launch {
            try {
                val db = FirebaseFirestore.getInstance()
                val productRef = db.collection("Product").document(productID)
                productRef.set(updatedProduct).await()
                getProductsData()
            } catch (e: Exception) {
                error.value = e.message
                Log.d("error", "editProduct: $e")
            }
        }
    }
}

// Function that fetches a list of products from Firestore and returns it.
suspend fun getProductsFromFireStore(): List<Product> {
    val db = FirebaseFirestore.getInstance()
    val productsList = mutableListOf<Product>()

    try {
        val result = db.collection("Product").get().await()

        if (result.isEmpty) {
            throw FirebaseFirestoreException("No products found", FirebaseFirestoreException.Code.NOT_FOUND)
        }

        for (document in result.documents) {
            val product = document.toObject(Product::class.java)
            if (product != null) {
                productsList.add(product)
            }
        }
    } catch (e: FirebaseFirestoreException) {
        Log.d("error", "getProductsFromFireStore: $e")
        throw e
    }

    return productsList
}


