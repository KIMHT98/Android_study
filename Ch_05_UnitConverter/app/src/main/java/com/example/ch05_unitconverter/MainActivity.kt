package com.example.ch05_unitconverter

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ch05_unitconverter.ui.theme.Ch05_UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ch05_UnitConverterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                   UnitConverter()
                }
            }
        }
    }
}
@Composable
fun UnitConverter(){
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Meters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val conversionFacotr = remember { mutableStateOf(1.00) }
    val oConversionFacotr = remember { mutableStateOf(1.00) }

    fun convertunits(){
        //숫자가 아니면 null이 되는데 null이면 0.0
        val inputValueDouble = inputValue.toDoubleOrNull()?:0.0
        val result = (inputValueDouble*conversionFacotr.value*100.0 /
                oConversionFacotr.value).roundToInt()/100.0
        outputValue = result.toString()
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //여기에 나오는 것이 화면에 쌓인다(위아래로)
        Text(text = "Unit Converter",style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
            //실행되어야 할 값을 입력해야 한다
            inputValue = it
                convertunits()
            },
            label = { Text(text = "Enter Value")})
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            //여기에 나오는 것은 화면에 나열됨(좌우로)
            //입력 박스
            Box {
                //입력 버튼
                Button(onClick = { iExpanded = true }) {
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription="Arrow Down")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeters") },
                        onClick = {
                            inputUnit = "Centimeters"
                            iExpanded = false
                            conversionFacotr.value = 0.01
                            convertunits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Meters") },
                        onClick = {
                            inputUnit = "Meters"
                            iExpanded = false
                            conversionFacotr.value = 1.0
                            convertunits()
                            }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Feet")  },
                        onClick = {
                            inputUnit = "Feet"
                            iExpanded = false
                            conversionFacotr.value = 0.3048
                            convertunits()
                            }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Milimeters") },
                        onClick = {
                            inputUnit = "Milimeters"
                            iExpanded = false
                            conversionFacotr.value = 0.001
                            convertunits()
                            }
                    )


                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box {
                Button(onClick = { oExpanded = true }) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription="Arrow Down")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded=false }) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeters") },
                        onClick = {
                            outputUnit = "Centimeters"
                            oExpanded = false
                            oConversionFacotr.value = 0.01
                            convertunits()

                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Meters") },
                        onClick = {
                            outputUnit = "Meters"
                            oExpanded = false
                            oConversionFacotr.value = 1.00
                            convertunits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Feet")  },
                        onClick = {
                            outputUnit = "Feet"
                            oExpanded = false
                            oConversionFacotr.value = 0.3048
                            convertunits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Milimeters") },
                        onClick = {
                            outputUnit = "Milimeters"
                            oExpanded = false
                            oConversionFacotr.value = 0.001
                            convertunits()
                        }
                    )


                }
            }
        }
        Text(text = "Result : ${outputValue} ${outputUnit}",
            style = MaterialTheme.typography.headlineMedium)
    }
}






@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}