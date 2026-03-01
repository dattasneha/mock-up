package com.snehadatta.mockup.home.presentation

import com.snehadatta.mockup.home.data.Topic
import com.snehadatta.mockup.home.data.TopicZone

data class HomeUiState(
    val isLoading: Boolean = false,
    val topicZones: List<TopicZone> = emptyList(),
    val topics: List<Topic> = emptyList(),
    val error: String? = null
)