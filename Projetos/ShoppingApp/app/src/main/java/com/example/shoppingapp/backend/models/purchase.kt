package com.example.shoppingapp.backend.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "purchase")
data class Purchase(
    @PrimaryKey @ColumnInfo(name = "purchaseID") val purchaseID: Int = 0,
    @ColumnInfo(name = "paymentType") val paymentType: String = "",
    @ColumnInfo(name = "userID") val userID: Int = 0,
    @ColumnInfo(name = "value") val value: Double = 0.0,
    @ColumnInfo(name = "shopCarID") val shopCarID: Int = 0
) {

    // Prepara os dados para serem salvos no Firestore
    fun toStore(): Map<String, Any?> {
        return mapOf(
            "purchaseID" to this.purchaseID,
            "paymentType" to this.paymentType,
            "userID" to this.userID,
            "value" to this.value,
            "shopCarID" to this.shopCarID
        )
    }

    companion object {
        // Cria um objeto Purchase a partir de dados do Firestore
        fun fromFirestore(data: Map<String, Any?>): Purchase {
            return Purchase(
                purchaseID = (data["purchaseID"] as? Number)?.toInt() ?: 0,
                paymentType = data["paymentType"] as? String ?: "",
                userID = (data["userID"] as? Number)?.toInt() ?: 0,
                value = (data["value"] as? Number)?.toDouble() ?: 0.0,
                shopCarID = (data["shopCarID"] as? Number)?.toInt() ?: 0
            )
        }
    }
}
