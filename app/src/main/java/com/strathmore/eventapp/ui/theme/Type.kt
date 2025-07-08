// File: ui/theme/Type.kt
package com.strathmore.eventapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val AppTypography = Typography(
    displayLarge = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold, color = StrathmoreBlue),
    titleLarge = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold, color = StrathmoreBlue),
    titleMedium = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Medium),
    bodyLarge = TextStyle(fontSize = 16.sp, color = StrathmoreBlack),
    bodyMedium = TextStyle(fontSize = 14.sp, color = StrathmoreBlack),
    labelLarge = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.SemiBold, color = StrathmoreRed)
)
