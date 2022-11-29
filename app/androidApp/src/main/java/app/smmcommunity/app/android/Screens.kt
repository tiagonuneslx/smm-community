package app.smmcommunity.app.android

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource

sealed class Screen(
    val route: String,
    @StringRes val stringResId: Int? = null,
    val icon: (@Composable () -> Painter)? = null,
) {
    object Login :
        Screen("login")

    object Tabs :
        Screen("/")

    object Levels :
        Screen("levels", R.string.nav_title_levels, { painterResource(R.drawable.ic_levels) })

    object Makers :
        Screen("makers", R.string.nav_title_makers, { painterResource(R.drawable.ic_makers) })

    object Add :
        Screen("add", R.string.nav_title_makers, { rememberVectorPainter(Icons.Default.Add) })

    object Lessons :
        Screen("lessons", R.string.nav_title_lessons, { painterResource(R.drawable.ic_lessons) })

    object Account :
        Screen("account", R.string.nav_title_account, { painterResource(R.drawable.ic_account) })
}

val tabs = listOf(
    Screen.Levels,
    Screen.Makers,
    Screen.Add,
    Screen.Lessons,
    Screen.Account,
)