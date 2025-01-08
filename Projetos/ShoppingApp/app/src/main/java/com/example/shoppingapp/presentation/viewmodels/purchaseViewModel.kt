package com.example.shoppingapp.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppingapp.firebase.models.Purchase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await



class PurchaseViewModel : ViewModel() {

    // State to hold the list of purchases
    val purchasesState = mutableStateOf<List<Purchase>>(emptyList())


    val loading = mutableStateOf(false)
    val error = mutableStateOf<String?>(null)


    // Function to add a new purchase to Firestore
    // This function adds a new purchase object to the "Purchases" collection in Firestore.
    fun addPurchase(purchase: Purchase) {
        viewModelScope.launch {
            try {

                val db = FirebaseFirestore.getInstance()
                db.collection("Purchases")
                    .add(purchase)
                    .await()


                getPurchases()
            } catch (e: FirebaseFirestoreException) {
                error.value = e.message
                Log.e("PurchaseViewModel", "Error adding purchase: $e")
            }
        }
    }

    // Function to fetch all purchases from Firestore
    // This function fetches all purchase documents from the "Purchases" collection in Firestore
    // and updates the state with the retrieved list.
    fun getPurchases() {
        viewModelScope.launch {
            loading.value = true
            try {
                val db = FirebaseFirestore.getInstance()
                val result = db.collection("Purchases").get().await()


                if (result.isEmpty) {
                    throw FirebaseFirestoreException("No purchases found", FirebaseFirestoreException.Code.NOT_FOUND)
                }


                val purchasesList = result.documents.mapNotNull { document ->
                    document.toObject(Purchase::class.java)
                }


                purchasesState.value = purchasesList
            } catch (e: FirebaseFirestoreException) {
                error.value = e.message
                Log.e("PurchaseViewModel", "Error getting purchases: $e")
            } finally {
                loading.value = false
            }
        }
    }
}

