package com.example.shoppingapp.backend.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "product")
data class Product(
    @PrimaryKey @ColumnInfo(name = "productID") val productID: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "name") val name: String = "",
    @ColumnInfo(name = "price") val price: Double = 0.0,
    @ColumnInfo(name = "productType") val productType: ProductType = ProductType.OTHER
) {

    // Prepara os dados para serem salvos no Firestore
    fun toStore(): Map<String, Any?> {
        return mapOf(
            "productID" to this.productID,
            "name" to this.name,
            "price" to this.price,
            "productType" to this.productType.name
        )
    }

    companion object {
        // Cria um objeto Product a partir de dados do Firestore
        fun fromFirestore(id: String, data: Map<String, Any?>): Product {
            return Product(
                productID = id,
                name = data["name"] as? String ?: "",
                price = (data["price"] as? Number)?.toDouble() ?: 0.0,
                productType = (data["productType"] as? String)?.let { ProductType.fromValue(it) } ?: ProductType.OTHER
            )
        }
    }
}

// Enum para representar os tipos de produto
enum class ProductType(val value: String) {
    ELECTRONICS("Electronics"),
    CLOTHING("Clothing"),
    GROCERY("Grocery"),
    OTHER("Other");

    companion object {
        // Método para converter uma string no enum correspondente
        fun fromValue(value: String): ProductType {
            return values().find { it.value.equals(value, ignoreCase = true) } ?: OTHER
        }
    }
}

