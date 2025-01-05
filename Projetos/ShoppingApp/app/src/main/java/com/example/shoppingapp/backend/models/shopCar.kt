package com.example.shoppingapp.backend.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopCar")
data class ShopCar(
    @PrimaryKey @ColumnInfo(name = "shopCarID") val shopCarID: Int = 0,
    @ColumnInfo(name = "productsIDs") val productsIDs: List<Int> = emptyList()
) {

    // Prepara os dados para serem salvos no Firestore
    fun toStore(): Map<String, Any?> {
        return mapOf(
            "shopCarID" to this.shopCarID,
            "productsIDs" to this.productsIDs
        )
    }

    companion object {
        // Cria um objeto ShopCar a partir de dados do Firestore
        fun fromFirestore(data: Map<String, Any?>): ShopCar {
            return ShopCar(
                shopCarID = (data["shopCarID"] as? Number)?.toInt() ?: 0,
                productsIDs = (data["productsIDs"] as? List<*>)?.mapNotNull {
                    (it as? Number)?.toInt()
                } ?: emptyList()
            )
        }
    }
}
