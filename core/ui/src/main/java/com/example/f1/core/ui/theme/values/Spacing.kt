package com.example.f1.core.ui.theme.values

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Spacing(
    val none: Dp = 0.dp,
    val small: Dp = 4.dp,
    val extraSmall: Dp = 8.dp,
    val mediumSmall: Dp = 14.dp,
    val medium: Dp = 16.dp,
    val mediumLarge: Dp = 20.dp,
    val large: Dp = 24.dp,
    val extraLarge: Dp = 32.dp,
    val driverImage: Dp = 140.dp
)

val LocalSpacing = staticCompositionLocalOf { Spacing() }