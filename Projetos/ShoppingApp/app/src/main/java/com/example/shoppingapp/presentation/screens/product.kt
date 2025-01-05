package com.example.shoppingapp.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shoppingapp.backend.models.Product
import com.example.shoppingapp.backend.models.ProductType
import com.example.shoppingapp.backend.viewmodels.ProductViewModel
import androidx.compose.runtime.getValue

@Composable
fun ProductScreen(navController: NavController, viewModel: ProductViewModel) {
    // Carrega os produtos no início
    remember {
        viewModel.loadProducts()
    }

    val products by viewModel.products.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Lista de produtos
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(products) { product ->
                ProductRow(product)
            }
        }

        // Botão para adicionar um produto
        Button(
            onClick = {
                val newProduct = Product(
                    name = "PlayStation",
                    price = 399.0,
                    productType = ProductType.ELECTRONICS
                )
                viewModel.saveProduct(newProduct)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Adicionar Produto")
        }
    }
}


@Composable
fun ProductRow(product: Product) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(48.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = product.name,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "${product.price} €",
            modifier = Modifier.weight(1f)
        )
    }
}