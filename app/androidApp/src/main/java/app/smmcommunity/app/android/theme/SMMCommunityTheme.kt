package app.smmcommunity.app.android.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import app.smmcommunity.app.android.R

private val Yellow = Color(0xFFFACD00)
private val YellowVariant = Color(0xFFFDB234)
private val Red = Color(0xFFE70012)
private val RedVariant = Color(0xFFF34C3D)
private val Grey200 = Color(0xffeeeeee)
private val Grey300 = Color(0xffe0e0e0)
private val Grey800 = Color(0xFF424242)
private val Grey850 = Color(0xFF323232)
private val Grey900 = Color(0xFF212121)
val Grey950 = Color(0xFF111111)

val DarkPurple = Color(0xFF170d2e)

val Nunito = FontFamily(
    Font(R.font.nunito_sans_semibold, FontWeight.SemiBold),
    Font(R.font.nunito_sans_bold, FontWeight.Bold),
    Font(R.font.nunito_sans_extrabold, FontWeight.ExtraBold),
)

private val DarkColors = darkColors(
    primary = Yellow,
    primaryVariant = YellowVariant,
    secondary = Red,
    secondaryVariant = RedVariant,
    background = DarkPurple,
    surface = Grey900,
    error = Red,
    onPrimary = Grey900,
    onSecondary = Grey200,
    onBackground = Grey200,
    onSurface = Grey200,
    onError = Grey200,
)

private val LightColors = lightColors(
    primary = Yellow,
    primaryVariant = YellowVariant,
    secondary = Red,
    secondaryVariant = RedVariant,
    background = Grey200,
    surface = Grey200,
    error = Red,
    onPrimary = Color.Black,
    onSecondary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black,
    onError = Color.White,
)

private val Typography = Typography(
    h1 = TextStyle(fontFamily = Nunito, fontSize = 26.sp, fontWeight = FontWeight.ExtraBold)
)

@Composable
fun SMMCommunityTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colors = if (darkTheme) DarkColors else LightColors,
        content = content,
        typography = Typography
    )
}