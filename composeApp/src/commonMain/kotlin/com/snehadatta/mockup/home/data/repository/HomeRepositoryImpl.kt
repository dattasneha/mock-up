package com.snehadatta.mockup.home.data.repository

import com.snehadatta.mockup.home.data.Topic
import com.snehadatta.mockup.home.data.TopicZone
import com.snehadatta.mockup.home.domain.HomeRepository
import kotlinx.serialization.json.Json
import myapplication.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi

class HomeRepositoryImpl : HomeRepository {

    private val json = Json { ignoreUnknownKeys = true }

    @OptIn(ExperimentalResourceApi::class)
    override suspend fun getTopicZones(): List<TopicZone> {
        return try {
            val jsonString = Res.readBytes("files/HomePageTopicZonesAndTopics.json").decodeToString()
            json.decodeFromString<List<TopicZone>>(jsonString)
        } catch (e: Exception) {
            emptyList()
        }
    }

    @OptIn(ExperimentalResourceApi::class)
    override suspend fun getTopics(): List<Topic> {
        return try {
            val jsonString = Res.readBytes("files/Topics.json").decodeToString()
            json.decodeFromString<List<Topic>>(jsonString)
        } catch (e: Exception) {
            emptyList()
        }
    }
}