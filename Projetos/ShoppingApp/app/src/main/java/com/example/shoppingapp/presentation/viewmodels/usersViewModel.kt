package com.example.shoppingapp.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppingapp.firebase.models.Users
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

// ViewModel responsible for fetching and managing user data.
class DataViewModel : ViewModel() {

    val state = mutableStateOf<List<Users>>(emptyList())
    val loading = mutableStateOf(false)
    val error = mutableStateOf<String?>(null)

    // Initialization block to fetch data when the ViewModel is created
    init {
        getData()
    }

    // Function to fetch user data from Firestore asynchronously.
    private fun getData() {
        viewModelScope.launch {
            loading.value = true
            try {
                state.value = getDataFromFireStore()
            } catch (e: Exception) {
                error.value = e.message
            } finally {
                loading.value = false
            }
        }
    }
}

// Function to fetch all users from Firestore and return as a list.
suspend fun getDataFromFireStore(): List<Users> {
    val db = FirebaseFirestore.getInstance()
    val usersList = mutableListOf<Users>()

    try {
        val result = db.collection("Users").get().await()
        if (result.isEmpty) {
            throw FirebaseFirestoreException("No users found", FirebaseFirestoreException.Code.NOT_FOUND)
        }

        for (document in result.documents) {
            val user = document.toObject(Users::class.java)
            if (user != null) {
                usersList.add(user)
            }
        }
    } catch (e: FirebaseFirestoreException) {
        Log.d("error", "getDataFromFireStore: $e")
        throw e
    }

    return usersList
}



