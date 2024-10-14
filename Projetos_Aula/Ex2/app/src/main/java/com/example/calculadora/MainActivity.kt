package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadora.ui.CalculatorButton
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

//Style for buttons
fun ButtonStyle(): Modifier {
    return Modifier
        .padding(3.dp)
        .height(40.dp)
        .width(90.dp)
}


@Composable
fun CalculatorInterface() {

    val result = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Calculator", color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(20.dp))

            // Calculator visor where will appear operations
            Box(
                modifier = Modifier
                    .width(300.dp)
                    .height(100.dp)
                    .border(BorderStroke(2.dp, Color.Gray), shape = RoundedCornerShape(8.dp))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                    Text(text = ".", fontSize = 36.sp, color = Color.Black)
            }

            Spacer(modifier = Modifier.height(20.dp))

                Row {
                    CalculatorButton(label = "√") { value ->
                        result.value += value
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    CalculatorButton(label = "%") { value ->
                        result.value += value
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    CalculatorButton(label = "+/-") { value ->
                        result.value += value
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    CalculatorButton(label = "CE") { value ->
                        result.value += value
                    }
                }
                Row {
                    CalculatorButton(label = "7") { value ->
                        result.value += value
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    CalculatorButton(label = "8") { value ->
                        result.value += value
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    CalculatorButton(label = "9") { value ->
                        result.value += value
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    CalculatorButton(label = "/") { value ->
                        result.value += value
                    }
                }
                Row {
                    CalculatorButton(label = "4") { value ->
                        result.value += value
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    CalculatorButton(label = "5") { value ->
                        result.value += value
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    CalculatorButton(label = "6") { value ->
                        result.value += value
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    CalculatorButton(label = "%") { value ->
                        result.value += value
                    }
                }
                Row {
                    CalculatorButton(label = "1") { value ->
                        result.value += value
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    CalculatorButton(label = "2") { value ->
                        result.value += value
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    CalculatorButton(label = "3") { value ->
                        result.value += value
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    CalculatorButton(label = "-") { value ->
                        result.value += value
                    }
                }
                Row {
                    CalculatorButton(label = "0") { value ->
                        result.value += value
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    CalculatorButton(label = ".") { value ->
                        result.value += value
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    CalculatorButton(label = "=") { value ->
                        result.value += value
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    CalculatorButton(label = "+") { value ->
                        result.value += value
                    }
                }

    }
}

