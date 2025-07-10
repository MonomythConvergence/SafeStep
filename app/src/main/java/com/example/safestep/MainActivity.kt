package com.example.safestep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.safestep.ui.theme.SafeStepTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SafeStepTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    OnboardingScreen1(
                    )
                }
            }
        }
    }
}

@Composable
fun OnboardingScreen1() {
    Column(verticalArrangement = Arrangement.Center) {
        Image(painterResource(Icons.Default.Check), "Safety icon")
        Text("Military-grade protection", style = MaterialTheme.typography.headlineMedium)
        Text("GDPR-ready encryption • Real-time anomaly detection")
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    SafeStepTheme {
        OnboardingScreen1()
    }
}