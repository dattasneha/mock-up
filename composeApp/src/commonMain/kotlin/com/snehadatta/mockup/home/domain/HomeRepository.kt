package com.snehadatta.mockup.home.domain

import com.snehadatta.mockup.home.data.Topic
import com.snehadatta.mockup.home.data.TopicZone

interface HomeRepository {
    suspend fun getTopicZones(): List<TopicZone>
    suspend fun getTopics(): List<Topic>
}