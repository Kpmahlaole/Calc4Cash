package za.co.katwebsystems.calc4cash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.text.DecimalFormat
import za.co.katwebsystems.calc4cash.ui.theme.Calc4CashTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calc4CashTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculateButton()
                }
            }
        }
    }
}

@Composable
fun CalculateButton() {
    var r10Text by remember { mutableStateOf("") }
    var r20Text by remember { mutableStateOf("") }
    var r50Text by remember { mutableStateOf("") }
    var r100Text by remember { mutableStateOf("") }
    var r200Text by remember { mutableStateOf("") }

    var resultR10 by remember { mutableFloatStateOf(0f) }
    var resultR20 by remember { mutableFloatStateOf(0f) }
    var resultR50 by remember { mutableFloatStateOf(0f) }
    var resultR100 by remember { mutableFloatStateOf(0f) }
    var resultR200 by remember { mutableFloatStateOf(0f) }

    // Grand total
    var grandTotal by remember { mutableFloatStateOf(0f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // R10
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            TextField(
                value = r10Text,
                onValueChange = { newText -> r10Text = newText },
                modifier = Modifier
                    .width(200.dp)
                    .padding(end = 4.dp),
                label = { Text("Enter R10 Count") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            //Text(text = "R10", modifier = Modifier.align(CenterVertically))

            // Result Box for R10
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(200.dp)
                    .height(55.dp)
                    .padding(end = 4.dp),
            ) {
                // Display the formatted result in the Box
                Text(text = formatCurrency(resultR10), modifier = Modifier.align(Center))
            }
        }

        // R20
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            TextField(
                value = r20Text,
                onValueChange = { newText -> r20Text = newText },
                modifier = Modifier
                    .width(200.dp)
                    .padding(end = 4.dp),
                label = { Text("Enter R20 Count") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            //Text(text = "R20", modifier = Modifier.align(CenterVertically))

            // Result Box for R20
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(200.dp)
                    .height(55.dp)
                    .padding(end = 4.dp),
            ) {
                // Display the formatted result in the Box
                Text(text = formatCurrency(resultR20), modifier = Modifier.align(Center))
            }
        }

        // R50
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            TextField(
                value = r50Text,
                onValueChange = { newText -> r50Text = newText },
                modifier = Modifier
                    .width(200.dp)
                    .padding(end = 4.dp),
                label = { Text("Enter R50 Count") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            //Text(text = "R50", modifier = Modifier.align(CenterVertically))

            // Result Box for R50
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(200.dp)
                    .height(55.dp)
                    .padding(end = 4.dp),
            ) {
                // Display the formatted result in the Box
                Text(text = formatCurrency(resultR50), modifier = Modifier.align(Center))
            }
        }

        // R100
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            TextField(
                value = r100Text,
                onValueChange = { newText -> r100Text = newText },
                modifier = Modifier
                    .width(200.dp)
                    .padding(end = 4.dp),
                label = { Text("Enter R100 Count") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            //Text(text = "R100", modifier = Modifier.align(CenterVertically))

            // Result Box for R100
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(200.dp)
                    .height(55.dp)
                    .padding(end = 4.dp),
            ) {
                // Display the formatted result in the Box
                Text(text = " ${formatCurrency(resultR100)}", modifier = Modifier.align(Center))
            }
        }

        // R200
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            TextField(
                value = r200Text,
                onValueChange = { newText -> r200Text = newText },
                modifier = Modifier
                    .width(200.dp)
                    .padding(end = 4.dp),
                label = { Text("Enter R200 Count") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            //Text(text = "R200", modifier = Modifier.align(CenterVertically))

            // Result Box for R200
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary)
                    .width(200.dp)
                    .height(55.dp)
                    .padding(end = 4.dp),
            ) {
                // Display the formatted result in the Box
                Text(text = " ${formatCurrency(resultR200)}", modifier = Modifier.align(Center))
            }
        }

        //add all the totals to get grand total here
        // Grand total
        Text(
            text = "Grand Total: ${formatCurrency(grandTotal)}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .align(CenterHorizontally)
        )

        Button(
            onClick = {
                // Calculate the result for R10
                resultR10 = r10Text.toFloatOrNull()?.times(10) ?: 0f

                // Calculate the result for R20
                resultR20 = r20Text.toFloatOrNull()?.times(20) ?: 0f

                // Calculate the result for R50
                resultR50 = r50Text.toFloatOrNull()?.times(50) ?: 0f

                // Calculate the result for R100
                resultR100 = r100Text.toFloatOrNull()?.times(100) ?: 0f

                // Calculate the result for R200
                resultR200 = r200Text.toFloatOrNull()?.times(200) ?: 0f

                // Calculate grand total
                grandTotal = resultR10 + resultR20 + resultR50 + resultR100 + resultR200

                // You can use these values for calculations or print them as needed
                println("Calculating... R10: ${formatCurrency(resultR10)}, R20: ${formatCurrency(resultR20)}, R50: ${formatCurrency(resultR50)}, R100: ${formatCurrency(resultR100)}, R200: ${formatCurrency(resultR200)}")
            },
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
        ) {
            Text(text = "Calculate")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculateButtonPreview() {
    Calc4CashTheme {
        CalculateButton()
    }
}

private fun formatCurrency(value: Float): String {
    val decimalFormat = DecimalFormat("#,##0.00")
    return "R${decimalFormat.format(value)}"
}
