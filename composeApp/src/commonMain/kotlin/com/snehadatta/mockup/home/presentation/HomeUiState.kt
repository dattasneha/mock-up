package com.snehadatta.mockup.home.presentation

import com.snehadatta.mockup.home.data.model.TopicZone

data class HomeUiState(
    val isLoading: Boolean = false,
    val topicZones: List<TopicZone> = emptyList(),
    val error: String? = null
)