package app.smmcommunity.app.android.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val Yellow = Color(0xFFFACD00)
private val YellowVariant = Color(0xFFFDB234)
private val Red = Color(0xFFE70012)
private val RedVariant = Color(0xFFF34C3D)
private val Dark = Color(0xFF121212)

private val DarkColors = darkColors(
    primary = Yellow,
    primaryVariant = YellowVariant,
    secondary = Red,
    secondaryVariant = RedVariant,
    background = Dark,
    surface = Dark,
    error = Red,
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    onError = Color.White,
)

private val LightColors = lightColors(
    primary = Yellow,
    primaryVariant = YellowVariant,
    secondary = Red,
    secondaryVariant = RedVariant,
    background = Color.White,
    surface = Color.White,
    error = Red,
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.White,
)

@Composable
fun SMMCommunityTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colors = if (darkTheme) DarkColors else LightColors,
        content = content,
    )
}