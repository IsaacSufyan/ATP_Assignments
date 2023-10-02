package com.atp.assignments.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView

private val darkColorScheme = darkColors(
    primary = LightGreen,
    secondary = DarkGreen,
    background = Black,
)

private val lightColorScheme = lightColors(
    primary = LightGreen,
    secondary = DarkGreen,
    background = Gray,
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = LightGreen.toArgb()
        }
    }

    MaterialTheme(
        colors = if (darkTheme) lightColorScheme else lightColorScheme,
        typography = Typography,
        content = content
    )
}