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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.snehadatta.mockup.home.data.model.Topic
import com.snehadatta.mockup.ui.theme.Dimensions
import com.snehadatta.mockup.ui.theme.MockupTheme
import com.snehadatta.mockup.ui.theme.PrimaryTeal
import com.snehadatta.mockup.ui.theme.Yellow
import com.snehadatta.mockup.ui.theme.appTypography
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.kwalaexpress2
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.decodeToImageBitmap
import org.jetbrains.compose.resources.painterResource

private object TopicRowDefaults {
    val topicTextSize = 10.sp
}

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
            modifier = Modifier.padding(Dimensions.spacingMedium),
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
            null
        }
    }

    Box(
        modifier = Modifier
            .height(Dimensions.topicCardHeight)
            .width(Dimensions.topicCardWidth),
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TopicImage(
                imageBitmap = imageBitmap,
                description = description
            )

            Text(
                text = description,
                fontSize = TopicRowDefaults.topicTextSize,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(Dimensions.spacingMedium),
                style = appTypography().bodySmall.copy(
                    color = Color.White
                ),
            )
        }
    }
}

@Composable
private fun TopicImage(
    imageBitmap: ImageBitmap?,
    description: String
) {
    val imageModifier = Modifier
        .height(Dimensions.topicImageHeight)
        .fillMaxWidth()
        .padding(horizontal = Dimensions.spacingMedium)
        .clip(RoundedCornerShape(Dimensions.cornerRadiusSmall))
        .border(
            width = Dimensions.borderWidthMedium,
            color = PrimaryTeal,
            shape = RoundedCornerShape(Dimensions.cornerRadiusSmall)
        )

    if (imageBitmap != null) {
        Image(
            bitmap = imageBitmap,
            contentDescription = description,
            modifier = imageModifier,
            contentScale = ContentScale.Crop,
        )
    } else {
        Image(
            painter = painterResource(Res.drawable.kwalaexpress2),
            contentDescription = description,
            modifier = imageModifier,
            contentScale = ContentScale.Crop,
        )
    }
}

@Preview(showBackground = true)
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