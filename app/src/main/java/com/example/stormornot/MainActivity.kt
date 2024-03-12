package com.example.stormornot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.stormornot.ui.theme.StormOrNotTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StormOrNotTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StormOrNot()
                }
            }
        }
    }
}

@Composable
fun StormOrNot(){
    val StormFound = remember{mutableStateOf(0)}
    val Direction = remember{ mutableStateOf("North")}

    Column {
        Text(text = "Storm Found : ${StormFound.value}")
        Text(text = "Current Direction : ${Direction.value}")

        Button(
            onClick = {
                Direction.value = "East"
                if(Random.nextBoolean()){
                    StormFound.value +=1
                }
            }) {
            Text(text = "Sail East")
        }
        Button(
            onClick = {
                Direction.value = "North"
                if(Random.nextBoolean()){
                    StormFound.value +=1
                }
            }) {
            Text(text = "Sail North")
        }
        Button(
            onClick = {
                Direction.value = "West"
                if(Random.nextBoolean()){
                    StormFound.value +=1
                }
            }) {
            Text(text = "Sail West")
        }
        Button(
            onClick = {
                Direction.value = "South"
                if(Random.nextBoolean()){
                    StormFound.value +=1
                }
            }) {
            Text(text = "Sail South")
        }
    }
}