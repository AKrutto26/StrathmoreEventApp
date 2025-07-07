package com.strathmore.eventapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = StrathmoreBlue,
    onPrimary = Color.White,
    primaryContainer = StrathmoreGold,
    onPrimaryContainer = Color.Black,
    secondary = StrathmoreRed,
    onSecondary = Color.White,
    secondaryContainer = StrathmoreYellow,
    onSecondaryContainer = Color.Black,
    background = Color.White,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black
)

@Composable
fun StrathmoreEventAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,
        shapes = AppShapes,
        content = content
    )
}

