package com.example.ch_10_navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ch_10_navigationsample.ui.theme.Ch_10_NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ch_10_NavigationSampleTheme {
                Surface(modifier = Modifier.fillMaxSize()
                , color = MaterialTheme.colorScheme.background) {
                    MyApp()
                }
            }
        }
    }
}


@Composable
fun MyApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "firstscreen")
    {
        composable(route = "firstscreen"){
            FirstScreen {
                navController.navigate("secondscreen")
            }
        }
        composable(route = "secondscreen"){
            SecondScreen() {
                name,age ->
                navController.navigate("thirdscreen/$name/$age")
            }
        }
        composable(route = "thirdscreen/{name}/{age}"){
            val name = it.arguments?.getString("name")?:"no name"
            val age = it.arguments?.getString("age")?:"0"
            ThirdScreen(name,age) {
                navController.navigate("firstscreen")
            }
        }
    }
}