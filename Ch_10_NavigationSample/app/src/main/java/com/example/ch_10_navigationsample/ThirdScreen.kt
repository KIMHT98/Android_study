package com.example.ch_10_navigationsample


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ThirdScreen(name:String,age:String,navigateToFirstScreen:()->Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This is the Third Screen", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Hi! $name", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "I'm $age years old!", fontSize = 24.sp)
        Button(onClick = {
            navigateToFirstScreen()
        }) {
            Text(text = "Go to First Screen")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ThirdPreview(){
    ThirdScreen("Terry","27",{})
}