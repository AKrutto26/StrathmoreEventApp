// File: ui/theme/Theme.kt
package com.strathmore.eventapp.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = StrathmoreBlue,
    onPrimary = Color.White,
    secondary = StrathmoreGold,
    onSecondary = StrathmoreBlack,
    background = LightGrayBackground,
    onBackground = StrathmoreBlack,
    error = StrathmoreRed,
    onError = Color.White
)

@Composable
fun StrathmoreEventAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = AppTypography,
        content = content
    )
}


