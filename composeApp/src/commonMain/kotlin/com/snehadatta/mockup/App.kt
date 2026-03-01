package com.snehadatta.mockup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.snehadatta.mockup.home.presentation.HomeScreen
import com.snehadatta.mockup.ui.theme.MockupTheme

@Composable
@Preview
fun App() {
    MockupTheme {

        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            HomeScreen()
        }
    }
}