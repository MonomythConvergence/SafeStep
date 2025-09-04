package com.example.features.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    //viewModel: VerificationCodeViewModel = hiltViewModel<VerificationCodeViewModel>()
) {

    //val uiState by viewModel.uiState.collectAsState()
    val scrollState = rememberScrollState()
//    viewModel.handleEvent(
//        event = VerificationCodeEvent.StartUp
//    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            Modifier.height(32.dp)
        )
        Text("Sensor output here:")
    }
}