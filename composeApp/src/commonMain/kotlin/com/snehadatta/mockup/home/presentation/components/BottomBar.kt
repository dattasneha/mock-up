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
import com.snehadatta.mockup.ui.theme.DarkBrown
import com.snehadatta.mockup.ui.theme.DeepBrown
import com.snehadatta.mockup.ui.theme.Dimensions
import com.snehadatta.mockup.ui.theme.MockupTheme
import myapplication.composeapp.generated.resources.Kwala_Rocket
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.gold_cart
import myapplication.composeapp.generated.resources.gold_home
import myapplication.composeapp.generated.resources.gold_inventory
import myapplication.composeapp.generated.resources.gold_leaderboard
import org.jetbrains.compose.resources.DrawableResource
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
            .height(Dimensions.bottomBarHeight)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = Dimensions.spacingXLarge)
                .padding(bottom = Dimensions.spacingSmall),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomBarIcon(
                icon = Res.drawable.gold_inventory,
                contentDescription = "inventory",
                onClick = onInventoryClick
            )
            BottomBarIcon(
                icon = Res.drawable.gold_cart,
                contentDescription = "cart",
                onClick = onCartClick
            )
            BottomBarIcon(
                icon = Res.drawable.gold_home,
                contentDescription = "home",
                onClick = onHomeClick
            )
            BottomBarIcon(
                icon = Res.drawable.gold_leaderboard,
                contentDescription = "leaderboard",
                onClick = onLeaderBoardClick
            )
            BottomBarIcon(
                icon = Res.drawable.Kwala_Rocket,
                contentDescription = "rocket",
                onClick = onRocketClick
            )
        }
    }
}

@Composable
private fun BottomBarIcon(
    icon: DrawableResource,
    contentDescription: String,
    onClick: () -> Unit
) {
    Image(
        painter = painterResource(icon),
        contentDescription = contentDescription,
        modifier = Modifier
            .clickable(onClick = onClick)
            .size(Dimensions.iconSizeLarge)
    )
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    MockupTheme {
        BottomBar()
    }
}