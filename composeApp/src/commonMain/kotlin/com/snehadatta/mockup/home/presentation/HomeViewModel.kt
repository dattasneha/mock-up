package com.snehadatta.mockup.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snehadatta.mockup.home.data.model.Topic
import com.snehadatta.mockup.home.data.model.TopicZone
import com.snehadatta.mockup.home.domain.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val homeRepository: HomeRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }

            try {
                val topicZonesData = homeRepository.getTopicZones()
                val topicsData = homeRepository.getTopics()

                // Create a map of topic ID to Topic data for quick lookup
                val topicMap = topicsData.associateBy { it.TopicId }

                // Map data models to UI models
                val topicZones = topicZonesData.map { zone ->
                    TopicZone(
                        title = zone.topicZoneName,
                        topics = zone.topics.mapNotNull { topicId ->
                            topicMap[topicId]?.let { topicData ->
                                Topic(
                                    topicId = topicData.TopicId,
                                    description = topicData.TopicName
                                )
                            }
                        }
                    )
                }

                _uiState.update {
                    it.copy(
                        isLoading = false,
                        topicZones = topicZones
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = e.message ?: "An error occurred"
                    )
                }
            }
        }
    }
}