package com.snehadatta.mockup.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.snehadatta.mockup.ui.theme.Yellow
import com.snehadatta.mockup.ui.theme.appFontFamily
import com.snehadatta.mockup.ui.theme.appTypography
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun TopicRow(
    title: String,
    topics: List<Topic>
) {
    Column {
        Text(
            text = title,
            style = appTypography().titleLarge,
            modifier = Modifier.padding(top = 8.dp),
            color = Yellow
        )
    }
    LazyRow(
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(topics.size) { topic ->
            TopicCard(
                description = topics[topic].description,
                topic = topics[topic].imageRes
            )
        }
    }
}

@Composable
fun TopicCard(
    description: String,
    topic: DrawableResource
) {

    Card(
        modifier = Modifier
            .width(160.dp),
        shape = RoundedCornerShape(1.5.dp)
    ) {
        Column {

            Image(
                painter = painterResource(topic),
                contentDescription = null,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Text(
                text = description,
                modifier = Modifier.padding(8.dp),
                color = Color.White,
                style = appTypography().bodySmall,
                textAlign = TextAlign.Center
            )
        }
    }

}
data class Topic(
    val description: String,
    val imageRes: DrawableResource
)

@Preview(
    showBackground = true,
)
@Composable
fun TopicRowPreview() {
    MaterialTheme {

//        TopicRow()

    }
}