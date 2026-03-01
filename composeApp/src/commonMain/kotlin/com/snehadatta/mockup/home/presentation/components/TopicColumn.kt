package com.snehadatta.mockup.home.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.snehadatta.mockup.home.data.model.TopicZone


@Composable
fun TopicColumn(
    topicZone: List<TopicZone>
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 32.dp)
    ){
        items(topicZone.size){ i->
            TopicRow(
                title = topicZone[i].title,
                topics = topicZone[i].topics
            )
        }
    }
}