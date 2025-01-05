package com.example.shoppingapp.backend.firebase


import com.example.shoppingapp.backend.models.Product
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.tasks.await

class ProductRepository {

    private val firestore = FirebaseFirestore.getInstance()
    private val productCollection = firestore.collection("products")

    // Adiciona ou atualiza um produto
    suspend fun saveProduct(product: Product) {
        productCollection.document(product.productID).set(product.toStore()).await()
    }

    // Busca todos os produtos
    suspend fun getAllProducts(): List<Product> {
        val snapshot = productCollection.get().await()
        return snapshot.toProducts()
    }

    // Busca um produto por ID
    suspend fun getProductById(productID: String): Product? {
        val snapshot = productCollection.document(productID).get().await()
        return if (snapshot.exists()) {
            Product.fromFirestore(productID, snapshot.data ?: emptyMap())
        } else null
    }

    // Remove um produto
    suspend fun deleteProduct(productID: String) {
        productCollection.document(productID).delete().await()
    }

    // Extensão para converter QuerySnapshot em lista de Product
    private fun QuerySnapshot.toProducts(): List<Product> {
        return this.documents.mapNotNull { doc ->
            doc.id?.let { Product.fromFirestore(it, doc.data ?: emptyMap()) }
        }
    }
}
