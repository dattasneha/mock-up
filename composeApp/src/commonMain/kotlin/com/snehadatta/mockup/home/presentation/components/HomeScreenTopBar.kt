package com.snehadatta.mockup.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.snehadatta.mockup.ui.theme.Blue
import com.snehadatta.mockup.ui.theme.CyanAccent
import com.snehadatta.mockup.ui.theme.DarkNavy
import com.snehadatta.mockup.ui.theme.DeepBlue
import com.snehadatta.mockup.ui.theme.Dimensions
import com.snehadatta.mockup.ui.theme.appTypography
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.dailyquiz
import myapplication.composeapp.generated.resources.kwalaexpress2
import myapplication.composeapp.generated.resources.topicoftheday3
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

private object HomeScreenTopBarDefaults {
    val iconSize = 60.dp
    val iconStartPadding = 30.dp
    val iconBottomPadding = 16.dp
    val textPadding = 4.dp
}

@Composable
fun HomeScreenTopBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Dimensions.spacingSmall),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        FeatureCard(
            modifier = Modifier.weight(0.9f),
            textTop = "Daily",
            textBottom = "Quiz",
            image = Res.drawable.dailyquiz
        )
        FeatureCard(
            modifier = Modifier.weight(0.9f),
            textTop = "Today's ",
            textBottom = "Topic",
            image = Res.drawable.topicoftheday3
        )
        FeatureCard(
            modifier = Modifier
                .weight(1f)
                .padding(end=2.dp),
            textTop = "Kwala",
            textBottom = "Express",
            image = Res.drawable.kwalaexpress2
        )
    }
}

@Composable
private fun FeatureCard(
    textTop: String,
    textBottom: String,
    image: DrawableResource,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(Dimensions.homeCardHeight)
            .padding(vertical = Dimensions.spacingSmall)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd)
                .padding(
                    start = HomeScreenTopBarDefaults.iconStartPadding,
                    bottom = HomeScreenTopBarDefaults.iconBottomPadding
                )
                .clip(RoundedCornerShape(Dimensions.cornerRadiusSmall))
                .border(
                    width = Dimensions.borderWidthMedium,
                    shape = RoundedCornerShape(Dimensions.cornerRadiusSmall),
                    color = Blue
                )
                .background(
                    brush = Brush.linearGradient(
                        listOf(DarkNavy, DeepBlue)
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(
                        start = 22.dp,
                    ),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                FeatureText(modifier = Modifier.padding(top = HomeScreenTopBarDefaults.textPadding),text = textTop)
                FeatureText(Modifier.padding(vertical = HomeScreenTopBarDefaults.textPadding),text = textBottom)
            }
        }

        Image(
            painter = painterResource(image),
            contentDescription = "$textTop $textBottom feature",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .size(HomeScreenTopBarDefaults.iconSize)
        )
    }
}

@Composable
private fun FeatureText(modifier: Modifier,text: String) {
    Text(
        text = text,
        modifier = modifier
            .padding(start = HomeScreenTopBarDefaults.textPadding)
        ,
        style = appTypography().labelLarge,
        color = CyanAccent,
        maxLines = 1,
        softWrap = true,
        textAlign = TextAlign.Start
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    MaterialTheme {
        HomeScreenTopBar()

    }
}