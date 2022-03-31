package com.geeksforgeeks.jcscrollablemodifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // Creating a Simple Scaffold Layout for the application
            Scaffold(

                // Creating a Top Bar
                topBar = { TopAppBar(title = { Text("GFG | Scrollable Modifier", color = Color.White) }, backgroundColor = Color(0xff0f9d58)) },

                // Creating Content
                content = {

                    // Creating a Column Layout
                    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

                        // actual composable state
                        var offset by remember { mutableStateOf(0f) }
                        
                        Box(
                            Modifier
                                .size(150.dp)
                                .scrollable(
                                    orientation = Orientation.Vertical,
                                    // Scrollable state: describes how to consume
                                    // scrolling delta and update offset
                                    state = rememberScrollableState { delta ->
                                        offset += delta
                                        delta
                                    }
                                )
                                .background(Color.LightGray),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(offset.toString())
                        }
                    }
                }
            )
        }
    }
}
