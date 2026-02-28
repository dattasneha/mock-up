package com.snehadatta.mockup.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.snehadatta.mockup.ui.theme.PrimaryTeal
import com.snehadatta.mockup.ui.theme.appFontFamily
import com.snehadatta.mockup.ui.theme.appTypography
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.dailyquiz
import myapplication.composeapp.generated.resources.kwalaexpress2
import myapplication.composeapp.generated.resources.topicoftheday3
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeScreenTopBar(
    modifier: Modifier = Modifier
){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ){
        Card(
            modifier = Modifier.weight(1f),
            textTop = "Daily",
            textBottom = "Quiz",
            image = Res.drawable.dailyquiz
        )
        Card(
            modifier = Modifier.weight(1f),
            textTop = "Today's ",
            textBottom = "Topic",
            image = Res.drawable.topicoftheday3
        )
        Card(
            modifier = Modifier.weight(1f),
            textTop = "Kwala",
            textBottom = "Express",
            image = Res.drawable.kwalaexpress2
        )
    }
}

@Composable
fun Card(
    modifier: Modifier = Modifier,
    textTop: String,
    textBottom: String,
    image: DrawableResource
){
    Box(
        modifier = modifier
            .padding(4.dp)
            .height(80.dp)
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd)
                .padding(start = 20.dp,end = 8.dp, bottom = 16.dp)
                .clip(RoundedCornerShape(1.5.dp))
                .border(
                    width = 1.5.dp,
                    shape = RoundedCornerShape(1.5.dp),
                    color = PrimaryTeal
                )
                .background(
                    color = Color.Transparent.copy(alpha = 0.3f)
                )
        ){
            Column (
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(4.dp)
                    .padding(end= 4.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = textTop,
                    modifier = Modifier
                        .padding(top = 4.dp),
                    style = appTypography().labelLarge,
                    color = PrimaryTeal,
                    maxLines = 1,
                    softWrap = true,
                    textAlign = TextAlign.Start
                )

                Text(
                    text = textBottom,
                    modifier = Modifier
                        .padding(bottom = 4.dp),
                    style = appTypography().labelLarge,
                    color = PrimaryTeal,
                    maxLines = 1,
                    softWrap = true,
                    textAlign = TextAlign.Start
                )
            }


        }
        Image(
            painter = painterResource(image),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .size(60.dp)

        )
    }

}

@Preview(
    showBackground = true,
)
@Composable
fun TopBarPreview() {
    MaterialTheme {

        HomeScreenTopBar()

    }
}