package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadora.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CalculatorInterface()
                }
            }
        }
    }
}

@Composable
fun CalculatorInterface() {
    Column {
        Text("\n\n\nCalculator")
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = { println("Button MRC clicked") }) {
                Text("MRC")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { println("Button M- clicked") }) {
                Text("M")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { println("Button M+ clicked") }) {
                Text("M+")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { println("Button ON/C clicked") }) {
                Text("ON/C")
            }
        }
        Row {
            Button(onClick = { println("Button √ clicked") }) {
                Text("√")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { println("Button % clicked") }) {
                Text("%")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { println("Button +/- clicked") }) {
                Text("+/-")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { println("Button CE clicked") }) {
                Text("CE")
            }
        }
        Row {
            Button(onClick = { println("Button 7 clicked") }) {
                Text("7")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { println("Button 8 clicked") }) {
                Text("8")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { println("Button 9 clicked") }) {
                Text("9")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { println("Button / clicked") }) {
                Text("/")
            }
        }
        Row {
            Button(onClick = { println("Button 6 clicked") }) {
                Text("4")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { println("Button 8 clicked") }) {
                Text("5")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { println("Button 9 clicked") }) {
                Text("6")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { println("Button % clicked") }) {
                Text("x")
            }
        }
        Row {
            Button(onClick = { println("Button 7 clicked") }) {
                Text("1")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { println("Button 8 clicked") }) {
                Text("2")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { println("Button 9 clicked") }) {
                Text("3")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { println("Button % clicked") }) {
                Text("-")
            }
        }
        Row {
            Button(onClick = { println("Button 0 clicked") }) {
                Text("0")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { println("Button . clicked") }) {
                Text(".")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { println("Button = clicked") }) {
                Text("=")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = { println("Button + clicked") }) {
                Text("+")
            }
        }
    }
}

