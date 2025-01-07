package com.example.shoppingapp.firebase.models

data class Purchase(
    val paymentType: String = "",
    val purchaseID: String = "",
    val shopCarID: String = "",
    val userID: String = "",
    val value: String = ""
)
