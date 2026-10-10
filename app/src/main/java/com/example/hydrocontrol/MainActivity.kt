
package com.example.hydrocontrol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                HydroControlScreen()
            }
        }
    }
}

@Composable
fun HydroControlScreen() {
    var ph by remember { mutableStateOf("5.8") }
    var ppm by remember { mutableStateOf("700") }
    var ec by remember { mutableStateOf("1.4") }
    var temp by remember { mutableStateOf("23.0") }
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            "HydroControl",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )

        Text("Гидропоника · Клубника «Альбион»")

        HorizontalDivider()

        OutlinedTextField(
            value = ph,
            onValueChange = { ph = it },
            label = { Text("pH") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = ppm,
            onValueChange = { ppm = it },
            label = { Text("PPM") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = ec,
            onValueChange = { ec = it },
            label = { Text("EC, mS/cm") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = temp,
            onValueChange = { temp = it },
            label = { Text("Температура воды, °C") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                message = "Показатели введены. Историю добавим следующим этапом."
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Сохранить измерение")
        }

        if (message.isNotEmpty()) {
            Text(message)
        }

        HorizontalDivider()

        Text("Текущие показатели",
            style = MaterialTheme.typography.titleLarge)

        Text("pH: $ph")
        Text("PPM: $ppm")
        Text("EC: $ec mS/cm")
        Text("Температура: $temp °C")

        Text(
            "Работа без интернета",
            style = MaterialTheme.typography.bodySmall
        )
    }
}
