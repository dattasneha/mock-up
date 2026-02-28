package com.snehadatta.mockup.ui

import androidx.compose.foundation.layout.Arrangement
import com.snehadatta.mockup.components.BottomBar
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.snehadatta.mockup.components.HomeScreenTopBar
import com.snehadatta.mockup.components.TopBar

@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TopBar(
                kp = 0,
                coins = 5000,
                diamonds = 10,
                onFreeClick = {},
                onSettingsClick = {},
            )
            HomeScreenTopBar(
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 90.dp)
        ) {

        }

        BottomBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun HomeScreenPreview() {
    MaterialTheme {

        HomeScreen()

    }
}