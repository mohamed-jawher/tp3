package com.example.myapplication33

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication33.ui.theme.MyApplication33Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplication33Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImageWithButton(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ImageWithButton(modifier: Modifier = Modifier) {
    var currentImage by remember {
        mutableIntStateOf(R.drawable.cycy)
    }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = currentImage),
            contentDescription = "Image à afficher",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))


        Button(onClick = {

            currentImage = if (currentImage == R.drawable.cycy) {
                R.drawable.cy
            } else {
                R.drawable.cycy
            }
        }) {
            Text("Changer d'image")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ImageWithButtonPreview() {
    MyApplication33Theme {
        ImageWithButton()
    }
}