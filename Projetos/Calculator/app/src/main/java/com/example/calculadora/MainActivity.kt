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
import kotlin.math.sqrt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorInterface()
        }
    }
}

// Function that will present calculator interface for the user
@Composable
fun CalculatorInterface() {
    val operation = remember { mutableStateOf("") }
    val result = remember { mutableStateOf("") }
    val isOperatorClicked = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .background(Color(0xFFE0E0E0))
            .border(2.dp, Color(0xFF000000), RoundedCornerShape(8.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Calculator",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Calculator display
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

            // Calculator buttons (line 1)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CalculatorButton("√", onClick = {
                    if (operation.value.isNotEmpty()) {
                        val number = result.value.toDoubleOrNull() ?: 0.0
                        result.value = if (number >= 0) sqrt(number).toString() else "Erro"
                        operation.value = result.value
                    } },
                    color = Color(0xFF000000)
                )
                CalculatorButton("%",
                    onClick = {},
                    color = Color(0xFF000000)
                )
                CalculatorButton("+/-",
                    onClick = {},
                    color = Color(0xFF000000)
                )
                CalculatorButton("CE",
                    onClick = {
                        operation.value = ""
                        result.value = "" },
                    color = Color(0xFFFF0000)
                )
            }

            // Calculator buttons (line 2, 3, 4 and 5)
            val buttons = listOf(
                listOf("7", "8", "9", "/"),
                listOf("4", "5", "6", "*"),
                listOf("1", "2", "3", "-"),
                listOf("0", ".", "=", "+")
            )

            // Create 1 row for each line of buttons
            for (row in buttons) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    // Create a button for each item on the line
                    for (item in row) {
                        CalculatorButton(
                            label = item,
                            onClick = {
                                // Calculate the result if button clicked is "="
                                when (item) { "=" -> {
                                        result.value = evaluateExpression(operation.value)
                                        operation.value = result.value
                                        isOperatorClicked.value = false
                                    }
                                    "+", "-", "*", "/" -> {
                                        if (!isOperatorClicked.value) {
                                            operation.value += item
                                            isOperatorClicked.value = true
                                        }
                                    }
                                    else -> {
                                        if (isOperatorClicked.value) {
                                            result.value = item
                                            isOperatorClicked.value = false
                                        } else {
                                            result.value += item
                                        }
                                        operation.value += item
                                    }
                                }
                            },
                            color = if (item in listOf("+", "-", "*", "/", "=")) Color(0xFF000000) else Color(0xFF696969)
                        )
                    }
                }
            }
        }
    }
}

// Function that analise the expression and calculate the result
fun evaluateExpression(expression: String): String {
    return try {
        val sanitizedExpression = expression.replace("%", "/100")
        val result = calculateExpression(sanitizedExpression)
        result.toString()
    } catch (e: Exception) {
        "Erro"
    }
}

// Function that calculate the expression
fun calculateExpression(expression: String): Double {
    val tokens = parseTokens(expression)
    if (tokens.isEmpty()) return 0.0

    val numbers = mutableListOf<Double>()
    val operators = mutableListOf<Char>()

    var i = 0
    while (i < tokens.size) {
        val token = tokens[i]
        when {
            token.first().isDigit() || token.first() == '.' -> numbers.add(token.toDouble())
            token in listOf("+", "-", "*", "/") -> {
                while (operators.isNotEmpty() && precedence(operators.last()) >= precedence(token.first())) {
                    processOperation(numbers, operators)
                }
                operators.add(token.first())
            }
        }
        i++
    }

    while (operators.isNotEmpty()) {
        processOperation(numbers, operators)
    }

    return numbers.first()
}

// Function that will process the operation
fun processOperation(numbers: MutableList<Double>, operators: MutableList<Char>) {
    if (numbers.size < 2 || operators.isEmpty()) return

    val second = numbers.removeAt(numbers.lastIndex)
    val first = numbers.removeAt(numbers.lastIndex)
    val operator = operators.removeAt(operators.lastIndex)

    val result = when (operator) {
        '+' -> first + second
        '-' -> first - second
        '*' -> first * second
        '/' -> if (second != 0.0) first / second else Double.NaN
        else -> 0.0
    }

    numbers.add(result)
}

// Operators precedence
fun precedence(operator: Char): Int {
    return when (operator) {
        '+', '-' -> 1
        '*', '/' -> 2
        else -> 0
    }
}

// Function that will analise the tokens
fun parseTokens(expression: String): List<String> {
    val tokens = mutableListOf<String>()
    var currentToken = StringBuilder()

    for (char in expression) {
        when {
            char.isDigit() || char == '.' -> currentToken.append(char)
            char in listOf('+', '-', '*', '/') -> {
                if (currentToken.isNotEmpty()) tokens.add(currentToken.toString())
                tokens.add(char.toString())
                currentToken = StringBuilder()
            }
        }
    }

    if (currentToken.isNotEmpty()) tokens.add(currentToken.toString())
    return tokens
}

// Function that create calculator buttons, receives button label, color, and action as arguments
@Composable
fun CalculatorButton(label: String, color: Color, onClick: () -> Unit) {
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


