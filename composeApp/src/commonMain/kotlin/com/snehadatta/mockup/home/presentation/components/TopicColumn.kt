package com.snehadatta.mockup.home.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.snehadatta.mockup.home.data.model.TopicZone
import com.snehadatta.mockup.ui.theme.Dimensions

@Composable
fun TopicColumn(
    topicZone: List<TopicZone>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = Dimensions.spacingXXLarge)
    ) {
        items(topicZone.size) { index ->
            TopicRow(
                title = topicZone[index].title,
                topics = topicZone[index].topics
            )
        }
    }
}