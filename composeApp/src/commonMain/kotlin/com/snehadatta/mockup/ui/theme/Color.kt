package com.snehadatta.mockup.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val PrimaryTeal = Color(0xFF1D8F8E)
val DarkTeal = Color(0xFF003A3D)
val DeepTeal = Color(0xFF005152)
val GoldAccent = Color(0xFFC2812F)
val DeepBrown = Color(0xFF1D0F0F)
val DarkBrown = Color(0xFF36200B)
val BluePrimary = Color(0xFF1F76D3)
val CyanAccent = Color(0xFF22E4EE)
val DarkNavy = Color(0xFF002351)
val DeepBlue = Color(0xFF003C83)
val Yellow = Color(0xFFE7E81C)
val Blue = Color(0xFF1F76D3)

val LightColors = lightColorScheme(
    primary = PrimaryTeal,
    secondary = GoldAccent,
    background = DeepBrown,
    surface = DarkBrown,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White
)

val DarkColors = darkColorScheme(
    primary = DarkTeal,
    secondary = GoldAccent,
    background = DeepBrown,
    surface = DarkBrown,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White
)