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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

