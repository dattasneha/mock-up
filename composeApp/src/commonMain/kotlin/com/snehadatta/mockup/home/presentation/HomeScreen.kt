package com.snehadatta.mockup.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import com.snehadatta.mockup.home.presentation.components.BottomBar
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.snehadatta.mockup.home.presentation.components.HomeScreenTopBar
import com.snehadatta.mockup.home.presentation.components.TopBar
import com.snehadatta.mockup.home.presentation.components.TopicRow
import com.snehadatta.mockup.home.data.model.Topic
import com.snehadatta.mockup.home.data.model.TopicZone
import com.snehadatta.mockup.home.presentation.components.TopicColumn
import com.snehadatta.mockup.ui.theme.MockupTheme
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.kwalaexpress2

@Composable
fun HomeScreen() {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TopBar(
                kp = 0,
                coins = 5000,
                diamonds = 10,
                onFreeClick = {},
                onSettingsClick = {},
            )
            HomeScreenTopBar(
                modifier = Modifier.padding(vertical = 4.dp)
            )
            TopicColumn(
                topicZone = listOf(
                    TopicZone(
                        title = "Most played topics",
                        topics = listOf(
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            )
                        )
                    ),
                    TopicZone(
                        title = "Most played topics",
                        topics = listOf(
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            )
                        )
                    ),
                    TopicZone(
                        title = "Most played topics",
                        topics = listOf(
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            )
                        )
                    ),
                    TopicZone(
                        title = "Most played topics",
                        topics = listOf(
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            )
                        )
                    ),
                    TopicZone(
                        title = "Most played topics",
                        topics = listOf(
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            )
                        )
                    ),
                    TopicZone(
                        title = "Most played topics",
                        topics = listOf(
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            ),
                            Topic(
                                description = "Indian ott",
                                imageRes = Res.drawable.kwalaexpress2
                            )
                        )
                    ),

                )

            )

        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 90.dp)
        ) {

        }

        BottomBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        )
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun HomeScreenPreview() {
    MockupTheme {

        HomeScreen()

    }
}