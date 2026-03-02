package com.snehadatta.mockup.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.snehadatta.mockup.home.presentation.components.BottomBar
import com.snehadatta.mockup.home.presentation.components.HomeScreenTopBar
import com.snehadatta.mockup.home.presentation.components.TopBar
import com.snehadatta.mockup.home.presentation.components.TopicColumn
import com.snehadatta.mockup.home.presentation.model.UserStats
import com.snehadatta.mockup.ui.components.ErrorState
import com.snehadatta.mockup.ui.components.LoadingState
import com.snehadatta.mockup.ui.theme.Dimensions
import com.snehadatta.mockup.ui.theme.MockupTheme
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopBar(
                modifier = Modifier.fillMaxWidth(),
                userStats = UserStats(
                    kp = 0,
                    coins = 5000,
                    diamonds = 10
                ),
                onFreeClick = {},
                onSettingsClick = {}
            )

            HomeScreenTopBar(
                modifier = Modifier.padding(vertical = Dimensions.spacingSmall)
            )

            HomeContent(uiState = uiState)
        }

        BottomBar(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
private fun HomeContent(uiState: HomeUiState) {
    when {
        uiState.isLoading -> LoadingState()
        uiState.error != null -> ErrorState(message = uiState.error)
        else -> TopicColumn(topicZone = uiState.topicZones)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MockupTheme {
        HomeScreen()

    }
}