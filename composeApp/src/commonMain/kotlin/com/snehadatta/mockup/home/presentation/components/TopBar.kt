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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.snehadatta.mockup.ui.theme.DarkBrown
import com.snehadatta.mockup.ui.theme.DarkTeal
import com.snehadatta.mockup.ui.theme.DeepBrown
import com.snehadatta.mockup.ui.theme.DeepTeal
import com.snehadatta.mockup.ui.theme.GoldAccent
import com.snehadatta.mockup.ui.theme.PrimaryTeal
import com.snehadatta.mockup.ui.theme.appTypography
import myapplication.composeapp.generated.resources.Avatar
import myapplication.composeapp.generated.resources.FreeCoin
import myapplication.composeapp.generated.resources.Res
import myapplication.composeapp.generated.resources.gold_settings
import myapplication.composeapp.generated.resources.topbar_icon
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun TopBar(
    kp: Int,
    coins: Int,
    diamonds: Int,
    onFreeClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .height(72.dp)
            .background(
                brush = Brush.verticalGradient(
                    listOf(DeepBrown, DarkBrown)
                )
            )
            .border(
                width = 1.5.dp,
                color = GoldAccent,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(vertical = 4.dp)
        ,
        contentAlignment = Alignment.Center

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(2.dp, end = 8.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(DeepTeal,DarkTeal))
                    )
                    .size(44.dp)
                    .border(
                        width = 1.dp,
                        color = PrimaryTeal,
                        shape = RoundedCornerShape(4.dp)
                    )
            ) {
                Image(
                    painter = painterResource(Res.drawable.Avatar),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                )
            }




            CurrencyItem(
                icon = Res.drawable.topbar_icon,
                value = kp
            )

            CurrencyItem(
                icon = Res.drawable.topbar_icon,
                value = coins
            )

            CurrencyItem(
                icon = Res.drawable.topbar_icon,
                value = diamonds
            )


            Spacer(modifier = Modifier.weight(1f))


            Image(
                painter = painterResource(Res.drawable.FreeCoin),
                contentDescription = "Free image",
                modifier = Modifier
                    .size(40.dp)
                    .clickable(true, onClick = onFreeClick)
            )
            Spacer(modifier= modifier.width(2.dp))
            Image(
                painter = painterResource(Res.drawable.gold_settings),
                contentDescription = "Settings",
                modifier = Modifier
                    .size(40.dp)
                    .clickable(true, onClick = onSettingsClick)
            )


        }
    }
}

@Composable
fun CurrencyItem(
    icon: DrawableResource,
    value: Int
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(1.dp))
            .padding(end = 2.dp)
            .height(44.dp)
            .width(68.dp)
            .background(
                brush = Brush.verticalGradient(
                    listOf(DeepTeal,DarkTeal)
                )
            )
            .border(
                width = 1.dp,
                color = PrimaryTeal,
                shape = RoundedCornerShape(4.dp)
            ),
        contentAlignment = Alignment.Center

    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(2.dp)
        ){
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = value.toString(),
                color = Color(0xFFFFD54F),
                style = appTypography().bodyMedium,
                modifier = Modifier.padding(2.dp)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GameTopBarPreviewStyled() {
    MaterialTheme {

        TopBar(
            kp = 0,
            coins = 5000,
            diamonds = 10,
            onFreeClick = {},
            onSettingsClick = {}
        )

    }
}