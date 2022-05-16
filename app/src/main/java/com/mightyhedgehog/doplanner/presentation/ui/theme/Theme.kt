package com.mightyhedgehog.doplanner.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun DoPlannerTheme(
    style: DoPlannerStyle = DoPlannerStyle.ORANGE,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = when (darkTheme) {
        true -> when(style) {
            DoPlannerStyle.ORANGE -> orangeDarkPalette
            DoPlannerStyle.BLUE -> blueDarkPalette
            DoPlannerStyle.PINK -> pinkDarkPalette
            DoPlannerStyle.PURPLE -> purpleDarkPalette
            DoPlannerStyle.GREEN -> greenDarkPalette
        }
        false -> when(style) {
            DoPlannerStyle.ORANGE -> orangeLightPalette
            DoPlannerStyle.BLUE -> blueLightPalette
            DoPlannerStyle.PINK -> pinkLightPalette
            DoPlannerStyle.PURPLE -> purpleLightPalette
            DoPlannerStyle.GREEN -> greenLightPalette
        }
    }
    val typography = doPlannerTypography
    val shapes = doPlannerShapes

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = true
        )
    }

    CompositionLocalProvider(
        LocalDoPlannerColors provides colors,
        LocalDoPlannerTypography provides typography,
        LocalDoPlannerShapes provides shapes,
        content = content
    )
}
