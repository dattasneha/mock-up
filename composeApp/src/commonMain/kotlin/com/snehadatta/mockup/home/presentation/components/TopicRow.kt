package com.snehadatta.mockup.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.snehadatta.mockup.home.data.model.Topic
import com.snehadatta.mockup.ui.theme.MockupTheme
import com.snehadatta.mockup.ui.theme.PrimaryTeal
import com.snehadatta.mockup.ui.theme.Yellow
import com.snehadatta.mockup.ui.theme.appTypography
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.kwalaexpress2
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.decodeToImageBitmap
import org.jetbrains.compose.resources.painterResource

@Composable
fun TopicRow(
    title: String,
    topics: List<Topic>
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = title,
            style = appTypography().titleMedium,
            modifier = Modifier.padding(8.dp),
            color = Yellow
        )
        LazyRow {
            items(topics.size) { index ->
                TopicCard(
                    topicId = topics[index].topicId,
                    description = topics[index].description
                )
            }
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun TopicCard(
    topicId: Int,
    description: String
) {
    var imageBitmap by remember(topicId) { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(topicId) {
        imageBitmap = try {
            Res.readBytes("drawable/$topicId.jpg").decodeToImageBitmap()
        } catch (e: Exception) {
            // Fallback to default image if topic image not found
            null
        }
    }

    Box(
        modifier = Modifier
            .height(120.dp)
            .width(100.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (imageBitmap != null) {
                Image(
                    bitmap = imageBitmap!!,
                    contentDescription = description,
                    modifier = Modifier
                        .height(80.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .clip(RoundedCornerShape(1.5.dp))
                        .border(
                            width = 1.5.dp,
                            color = PrimaryTeal,
                            shape = RoundedCornerShape(1.5.dp)
                        ),
                    contentScale = ContentScale.Crop,
                )
            } else {
                // Fallback to default image
                Image(
                    painter = painterResource(Res.drawable.kwalaexpress2),
                    contentDescription = description,
                    modifier = Modifier
                        .height(80.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                        .clip(RoundedCornerShape(1.5.dp))
                        .border(
                            width = 1.5.dp,
                            color = PrimaryTeal,
                            shape = RoundedCornerShape(1.5.dp)
                        ),
                    contentScale = ContentScale.Crop,
                )
            }

            Text(
                text = description,
                modifier = Modifier.padding(8.dp),
                style = appTypography().bodySmall.copy(
                    color = Color.White
                ),
            )
        }
    }
}


@Preview(
    showBackground = true,
)
@Composable
fun TopicRowPreview() {
    MockupTheme {
        TopicRow(
            title = "Most played topics",
            topics = listOf(
                Topic(
                    topicId = 2314,
                    description = "Indian OTTs"
                ),
                Topic(
                    topicId = 2312,
                    description = "Anime"
                ),
                Topic(
                    topicId = 2313,
                    description = "Marvel Disney Universe"
                )
            )
        )

    }
}