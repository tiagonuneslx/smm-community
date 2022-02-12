package app.smmcommunity.app.android

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed class Screen(
    val route: String,
    @StringRes val stringResId: Int,
    @DrawableRes val drawableResId: Int,
) {
    object Levels : Screen("levels", R.string.nav_title_levels, R.drawable.ic_levels)
    object Makers : Screen("makers", R.string.nav_title_makers, R.drawable.ic_makers)
    object Lessons : Screen("lessons", R.string.nav_title_lessons, R.drawable.ic_lessons)
    object Account : Screen("account", R.string.nav_title_account, R.drawable.ic_account)
}

val screens = listOf(
    Screen.Levels,
    Screen.Makers,
    Screen.Lessons,
    Screen.Account,
)