package com.snehadatta.mockup.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.snehadatta.mockup.ui.theme.DarkBrown
import com.snehadatta.mockup.ui.theme.DeepBrown
import com.snehadatta.mockup.ui.theme.MockupTheme
import myapplication.composeapp.generated.resources.Kwala_Rocket
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.gold_cart
import myapplication.composeapp.generated.resources.gold_home
import myapplication.composeapp.generated.resources.gold_inventory
import myapplication.composeapp.generated.resources.gold_leaderboard
import org.jetbrains.compose.resources.painterResource

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    onInventoryClick: () -> Unit = {},
    onHomeClick: () -> Unit = {},
    onCartClick: () -> Unit = {},
    onLeaderBoardClick: () -> Unit = {},
    onRocketClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    listOf(DeepBrown, DarkBrown)
                )
            )
            .height(64.dp)

    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .padding(bottom = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(Res.drawable.gold_inventory),
                contentDescription = "inventory",
                modifier = Modifier
                    .clickable(onClick = onInventoryClick)
                    .size(60.dp)
            )


            Image(
                painter = painterResource(Res.drawable.gold_cart),
                contentDescription = "cart",
                modifier = Modifier.clickable(onClick = onCartClick)
                    .size(60.dp)
            )


            Image(
                painter = painterResource(Res.drawable.gold_home),
                contentDescription = "home",
                modifier = Modifier.clickable(onClick = onHomeClick)
                    .size(60.dp)

            )
            Image(
                painter = painterResource(Res.drawable.gold_leaderboard),
                contentDescription = "leaderboard",
                modifier = Modifier.clickable(onClick = onLeaderBoardClick)
                    .size(60.dp)
            )
            Image(
                painter = painterResource(Res.drawable.Kwala_Rocket),
                contentDescription = "rocket",
                modifier = Modifier.clickable(onClick = onRocketClick)
                    .size(60.dp)

            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    MockupTheme {
        BottomBar()
    }
}