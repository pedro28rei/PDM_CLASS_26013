package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadora.ui.theme.CalculadoraTheme
import kotlin.math.sqrt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraTheme {
                CalculatorInterface()
            }
        }
    }
}

@Composable
fun CalculatorInterface() {
    val operation = remember { mutableStateOf("") }
    val result = remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .background(Color(0xFFE0E0E0)) // Cor de fundo para a calculadora
            .border(2.dp, Color(0xFF000000), RoundedCornerShape(8.dp)) // Borda preta com cantos arredondados
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize() // Preenche o espaço disponível dentro do Box
                .padding(8.dp), // Ajuste do padding para que o conteúdo tenha espaço interno
            verticalArrangement = Arrangement.Top, // Ajuste a posição para o topo
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Calculadora",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Visor da calculadora
            Box(
                modifier = Modifier
                    .width(300.dp)
                    .height(100.dp)
                    .border(BorderStroke(2.dp, Color.Gray), shape = RoundedCornerShape(8.dp))
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = if (result.value.isEmpty()) operation.value else result.value,
                    fontSize = 36.sp,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

// Primeira Linha de Botões
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalculatorButton("√", onClick = {
                    if (operation.value.isNotEmpty()) {
                        val number = operation.value.toDoubleOrNull()
                        result.value =
                            if (number != null && number >= 0) sqrt(number).toString() else "Erro"
                    }
                }, color = Color(0xFF000000))

                CalculatorButton(
                    "%",
                    onClick = { operation.value += "%" },
                    color = Color(0xFF000000)
                )

                CalculatorButton("+/-", onClick = {
                    if (operation.value.isNotEmpty() && operation.value.first() != '-') {
                        operation.value = "-${operation.value}"
                    } else if (operation.value.startsWith("-")) {
                        operation.value = operation.value.drop(1)
                    }
                }, color = Color(0xFF000000))

                CalculatorButton("CE", onClick = {
                    operation.value = operation.value.dropLast(1)
                }, color = Color(0xFFFF0000))
            }

// Segunda Linha de Botões
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalculatorButton(
                    "7",
                    onClick = { operation.value += "7" },
                    color = Color(0xFF696969)
                )
                CalculatorButton(
                    "8",
                    onClick = { operation.value += "8" },
                    color = Color(0xFF696969)
                )
                CalculatorButton(
                    "9",
                    onClick = { operation.value += "9" },
                    color = Color(0xFF696969)
                )
                CalculatorButton(
                    "/",
                    onClick = { operation.value += "/" },
                    color = Color(0xFF000000)
                )
            }

// Terceira Linha de Botões
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalculatorButton(
                    "4",
                    onClick = { operation.value += "4" },
                    color = Color(0xFF696969)
                )
                CalculatorButton(
                    "5",
                    onClick = { operation.value += "5" },
                    color = Color(0xFF696969)
                )
                CalculatorButton(
                    "6",
                    onClick = { operation.value += "6" },
                    color = Color(0xFF696969)
                )
                CalculatorButton(
                    "*",
                    onClick = { operation.value += "*" },
                    color = Color(0xFF000000)
                )
            }

// Quarta Linha de Botões
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalculatorButton(
                    "1",
                    onClick = { operation.value += "1" },
                    color = Color(0xFF696969)
                )
                CalculatorButton(
                    "2",
                    onClick = { operation.value += "2" },
                    color = Color(0xFF696969)
                )
                CalculatorButton(
                    "3",
                    onClick = { operation.value += "3" },
                    color = Color(0xFF696969)
                )
                CalculatorButton(
                    "-",
                    onClick = { operation.value += "-" },
                    color = Color(0xFF000000)
                )
            }

// Quinta Linha de Botões
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalculatorButton(
                    "0",
                    onClick = { operation.value += "0" },
                    color = Color(0xFF696969)
                )
                CalculatorButton(
                    ".",
                    onClick = { operation.value += "." },
                    color = Color(0xFF696969)
                )
                CalculatorButton("=", onClick = {
                    result.value = evaluateExpression(operation.value)
                    operation.value = ""
                }, color = Color(0xFF696969))
                CalculatorButton(
                    "+",
                    onClick = { operation.value += "+" },
                    color = Color(0xFF000000)
                )
            }
        }
    }
}

// Função para analisar e calcular a expressão
fun evaluateExpression(expression: String): String {
    return try {
        val tokens = parseTokens(expression.replace("%", "/100"))
        val result = calculate(tokens)
        result.toString()
    } catch (e: Exception) {
        "Erro"
    }
}

// Função para analisar tokens da expressão
fun parseTokens(expression: String): MutableList<String> {
    val tokens = mutableListOf<String>()
    var currentNumber = StringBuilder()
    for (char in expression) {
        when (char) {
            '+', '-', '*', '/' -> {
                if (currentNumber.isNotEmpty()) {
                    tokens.add(currentNumber.toString())
                    currentNumber = StringBuilder()
                }
                tokens.add(char.toString())
            }
            else -> currentNumber.append(char)
        }
    }
    if (currentNumber.isNotEmpty()) tokens.add(currentNumber.toString())
    return tokens
}

// Função para calcular o resultado
fun calculate(tokens: MutableList<String>): Double {
    val numbers = mutableListOf<Double>()
    val operators = mutableListOf<String>()

    var i = 0
    while (i < tokens.size) {
        val token = tokens[i]
        when (token) {
            "+" -> operators.add(token)
            "-" -> operators.add(token)
            "*" -> operators.add(token)
            "/" -> operators.add(token)
            else -> numbers.add(token.toDouble())
        }

        if (operators.size > 0 && numbers.size >= 2) {
            val operator = operators.removeAt(operators.size - 1)
            val secondOperand = numbers.removeAt(numbers.size - 1)
            val firstOperand = numbers.removeAt(numbers.size - 1)

            val result = when (operator) {
                "+" -> firstOperand + secondOperand
                "-" -> firstOperand - secondOperand
                "*" -> firstOperand * secondOperand
                "/" -> firstOperand / secondOperand
                else -> 0.0
            }
            numbers.add(result)
        }

        i++
    }

    return numbers.first()
}


// Function that will create calculator buttons, receives button label and color as arguments
@Composable
fun CalculatorButton(label: String, onClick: () -> Unit, color: Color) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(4.dp)
            .height(60.dp)
            .width(80.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        Text(
            text = label,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}




