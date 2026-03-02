package com.snehadatta.mockup.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.snehadatta.mockup.home.presentation.model.UserStats
import com.snehadatta.mockup.ui.theme.DarkBrown
import com.snehadatta.mockup.ui.theme.DarkTeal
import com.snehadatta.mockup.ui.theme.DeepBrown
import com.snehadatta.mockup.ui.theme.DeepTeal
import com.snehadatta.mockup.ui.theme.Dimensions
import com.snehadatta.mockup.ui.theme.GoldAccent
import com.snehadatta.mockup.ui.theme.GoldText
import com.snehadatta.mockup.ui.theme.PrimaryTeal
import com.snehadatta.mockup.ui.theme.appTypography
import myapplication.composeapp.generated.resources.Avatar
import myapplication.composeapp.generated.resources.FreeCoin
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.gold_settings
import myapplication.composeapp.generated.resources.topbar_icon
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

private object TopBarDefaults {
    val currencyItemMinWidth = 64.dp
    val avatarContainerSize = 48.dp
    val horizontalSpacing = 2.dp
}

@Composable
fun TopBar(
    userStats: UserStats,
    onFreeClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Dimensions.spacingMedium)
            .clip(RoundedCornerShape(Dimensions.cornerRadiusMedium))
            .height(Dimensions.topBarHeight)
            .background(
                brush = Brush.verticalGradient(
                    listOf(DeepBrown, DarkBrown)
                )
            )
            .border(
                width = Dimensions.borderWidthMedium,
                color = GoldAccent,
                shape = RoundedCornerShape(Dimensions.cornerRadiusMedium)
            )
            .padding(vertical = Dimensions.spacingSmall),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(TopBarDefaults.horizontalSpacing),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimensions.spacingLarge)
        ) {
            AvatarSection()
            CurrencySection(userStats = userStats)
            Spacer(modifier = Modifier.weight(1f))
            ActionButtons(
                onFreeClick = onFreeClick,
                onSettingsClick = onSettingsClick
            )
        }
    }
}

@Composable
private fun AvatarSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(Dimensions.spacingXSmall, end = Dimensions.spacingMedium)
            .background(
                brush = Brush.verticalGradient(
                    listOf(DeepTeal, DarkTeal)
                )
            )
            .size(TopBarDefaults.avatarContainerSize)
            .border(
                width = Dimensions.borderWidthThin,
                color = PrimaryTeal,
                shape = RoundedCornerShape(Dimensions.cornerRadiusMedium)
            )
    ) {
        Image(
            painter = painterResource(Res.drawable.Avatar),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(Dimensions.iconSizeMedium)
                .clip(CircleShape)
        )
    }
}

@Composable
private fun CurrencySection(userStats: UserStats) {
    CurrencyItem(
        icon = Res.drawable.topbar_icon,
        value = userStats.kp
    )
    CurrencyItem(
        icon = Res.drawable.topbar_icon,
        value = userStats.coins
    )
    CurrencyItem(
        icon = Res.drawable.topbar_icon,
        value = userStats.diamonds
    )
}

@Composable
private fun ActionButtons(
    onFreeClick: () -> Unit,
    onSettingsClick: () -> Unit
) {
    Image(
        painter = painterResource(Res.drawable.FreeCoin),
        contentDescription = "Free coins",
        modifier = Modifier
            .size(Dimensions.iconSizeMedium)
            .clickable(onClick = onFreeClick)
    )
    Image(
        painter = painterResource(Res.drawable.gold_settings),
        contentDescription = "Settings",
        modifier = Modifier
            .size(Dimensions.iconSizeMedium)
            .clickable(onClick = onSettingsClick)
    )
}

@Composable
private fun CurrencyItem(
    icon: DrawableResource,
    value: Int
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(Dimensions.borderWidthThin))
            .padding(end = Dimensions.spacingXSmall)
            .height(Dimensions.avatarSize)
            .widthIn(min = TopBarDefaults.currencyItemMinWidth)
            .background(
                brush = Brush.verticalGradient(
                    listOf(DeepTeal, DarkTeal)
                )
            )
            .border(
                width = Dimensions.borderWidthThin,
                color = PrimaryTeal,
                shape = RoundedCornerShape(Dimensions.cornerRadiusMedium)
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(Dimensions.spacingXSmall)
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(Dimensions.iconSizeSmall)
            )
            Text(
                text = value.toString(),
                color = GoldText,
                style = appTypography().bodyMedium,
                modifier = Modifier.padding(Dimensions.spacingXSmall)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameTopBarPreviewStyled() {
    MaterialTheme {
        TopBar(
            userStats = UserStats(
                kp = 0,
                coins = 5000,
                diamonds = 10
            ),
            onFreeClick = {},
            onSettingsClick = {}
        )

    }
}