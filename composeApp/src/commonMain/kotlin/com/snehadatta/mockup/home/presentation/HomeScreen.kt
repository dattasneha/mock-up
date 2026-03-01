package com.snehadatta.mockup.home.presentation

import androidx.compose.foundation.layout.Arrangement
import com.snehadatta.mockup.home.presentation.components.BottomBar
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.snehadatta.mockup.home.presentation.components.HomeScreenTopBar
import com.snehadatta.mockup.home.presentation.components.TopBar
import com.snehadatta.mockup.home.presentation.components.TopicColumn
import com.snehadatta.mockup.ui.theme.MockupTheme
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TopBar(
                modifier = Modifier.fillMaxWidth(),
                kp = 0,
                coins = 5000,
                diamonds = 10,
                onFreeClick = {},
                onSettingsClick = {},
            )
            HomeScreenTopBar(
                modifier = Modifier.padding(vertical = 4.dp)
            )

            when {
                uiState.isLoading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                uiState.error != null -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = uiState.error ?: "Unknown error",
                            color = Color.Red
                        )
                    }
                }
                else -> {
                    TopicColumn(
                        topicZone = uiState.topicZones
                    )
                }
            }
        }

        BottomBar(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun HomeScreenPreview() {
    MockupTheme {

        HomeScreen()

    }
}