package com.example.shoppingapp.backend.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey @ColumnInfo(name = "userID") val userID: Int = 0, // Alterado para Int
    @ColumnInfo(name = "name") val name: String = "",
    @ColumnInfo(name = "birthDate") val birthDate: String = "",
    @ColumnInfo(name = "email") val email: String = "",
    @ColumnInfo(name = "nif") val nif: Int = 0,
    @ColumnInfo(name = "password") val password: String = "",
    @ColumnInfo(name = "userType") val userType: UserType = UserType.CLIENT
) {

    // Prepara os dados para serem salvos no Firestore
    fun toStore(): Map<String, Any?> {
        return mapOf(
            "userID" to this.userID,
            "name" to this.name,
            "birthDate" to this.birthDate,
            "email" to this.email,
            "nif" to this.nif,
            "password" to this.password, // Incluído caso necessário
            "userType" to this.userType.value // Enum convertido para valor String
        )
    }

    companion object {
        // Cria um objeto User a partir de dados do Firestore
        fun fromFirestore(data: Map<String, Any?>): User {
            return User(
                userID = (data["userID"] as? Number)?.toInt() ?: 0, // Alterado para Int
                name = data["name"] as? String ?: "",
                birthDate = data["birthDate"] as? String ?: "",
                email = data["email"] as? String ?: "",
                nif = (data["nif"] as? Number)?.toInt() ?: 0,
                password = data["password"] as? String ?: "",
                userType = (data["userType"] as? String)?.let { UserType.fromValue(it) } ?: UserType.CLIENT
            )
        }
    }
}

// Enum para representar os tipos de usuário
enum class UserType(val value: String) {
    CLIENT("Cliente"),
    ADMIN("Admin"),
    SELLER("Vendedor");

    companion object {
        // Método para converter uma string no enum correspondente
        fun fromValue(value: String): UserType {
            return values().find { it.value.equals(value, ignoreCase = true) } ?: CLIENT
        }
    }
}

