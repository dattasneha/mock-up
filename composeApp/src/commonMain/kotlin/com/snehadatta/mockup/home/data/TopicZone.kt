package com.snehadatta.mockup.home.data

import kotlinx.serialization.Serializable

@Serializable
data class TopicZone(
    val id: Int,
    val topicZoneName: String,
    val topics: List<Int>
)

@Serializable
data class Topic(
    val TopicId: Int,
    val TopicName: String
)
