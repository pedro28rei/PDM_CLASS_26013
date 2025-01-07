package com.example.shoppingapp.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppingapp.firebase.models.Users
import  com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class DataViewModel: ViewModel()  {
    val state = mutableStateOf(Users())

    init {
        getData()
    }

    private fun getData(){
        viewModelScope.launch {
            state.value = getDataFromFireStore()

        }
    }
}


suspend fun getDataFromFireStore(): Users {
    val db = FirebaseFirestore.getInstance()
    var users = Users()

    try {
        db.collection("Users").get().await().map {
            val result = it.toObject(Users::class.java)
            users = result
        }
    } catch (e: FirebaseFirestoreException) {

        Log.d("error", "getDataFromFiraStore: $e")


    }

    return users
}

