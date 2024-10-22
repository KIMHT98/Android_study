package com.example.ch_06_captaingame

import android.graphics.Paint.Cap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ch_06_captaingame.ui.theme.Ch_06_CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ch_06_CaptainGameTheme {
               Surface(modifier = Modifier.fillMaxSize(),
                   color = MaterialTheme.colorScheme.background) {
                   CaptainGame()
               }
            }
        }
    }
}

@Composable
fun CaptainGame() {
    var treasuresFound by remember {mutableStateOf(0)}
    val direction = remember { mutableStateOf("North") }
    val stormOrTreasure = remember {
        mutableStateOf("")
    }
    Column {
        Text(text = "Treasures Found: ${treasuresFound}")
        Text(text = "Current Direction: ${direction.value}")
        Button(onClick = {
            direction.value = "East"
            if(Random.nextBoolean()){
                treasuresFound += 1
                stormOrTreasure.value = "Found a Treasure!"
            }else{
                stormOrTreasure.value = "Storm Ahead!"
            }

        }) {
            Text(text = "Sail East")
        }
        Button(onClick = {
            direction.value = "West"
            if(Random.nextBoolean()){
                treasuresFound += 1
                stormOrTreasure.value = "Found a Treasure!"
            }else{
                stormOrTreasure.value = "Storm Ahead!"
            }
        }) {
            Text(text = "Sail West")
        }
        Button(onClick = {
            direction.value = "North"
            if(Random.nextBoolean()){
                treasuresFound += 1
                stormOrTreasure.value = "Found a Treasure!"
            }else{
                stormOrTreasure.value = "Storm Ahead!"
            }
        }) {
            Text(text = "Sail North")
        }
        Button(onClick = {
            direction.value = "South"
            if(Random.nextBoolean()){
                treasuresFound += 1
                stormOrTreasure.value = "Found a Treasure!"
            }else{
                stormOrTreasure.value = "Storm Ahead!"
            }
        }) {
            Text(text = "Sail South")
        }
        Text(text = "Storm Or Treasure : ${stormOrTreasure.value}")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ch_06_CaptainGameTheme {
        CaptainGame()
    }
}