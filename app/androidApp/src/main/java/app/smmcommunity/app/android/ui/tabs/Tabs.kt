package app.smmcommunity.app.android.ui.tabs

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.smmcommunity.app.android.Screen
import app.smmcommunity.app.android.tabs
import app.smmcommunity.app.android.ui.tabs.account.AccountPage
import app.smmcommunity.app.android.ui.tabs.lessons.LessonsPage
import app.smmcommunity.app.android.ui.tabs.levels.LevelsPage
import app.smmcommunity.app.android.ui.tabs.makers.MakersPage
import com.google.accompanist.insets.ui.Scaffold
import com.google.accompanist.systemuicontroller.SystemUiController

@Composable
fun Tabs(systemUiController: SystemUiController) {
    val isDark = isSystemInDarkTheme()
    val backgroundColor = MaterialTheme.colors.background
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = !isDark,
        )
        systemUiController.setNavigationBarColor(
            color = backgroundColor,
            darkIcons = !isDark,
        )
    }
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                Arrangement.SpaceBetween,
                Alignment.Bottom
            ) {
                tabs.forEach { screen ->
                    if (screen.route == "add") {
                        val primaryColor = MaterialTheme.colors.primary
                        Box(
                            Modifier
                                .padding(bottom = 4.dp)
                                .clip(CircleShape)
                                .size(58.dp)
                                .drawBehind {
                                    drawIntoCanvas { canvas ->
                                        canvas.nativeCanvas.apply {
                                            drawCircle(
                                                size.width / 2,
                                                size.width / 2,
                                                (size.width - 12.dp.toPx()) / 2,
                                                Paint()
                                                    .asFrameworkPaint()
                                                    .apply {
                                                        isAntiAlias = true
                                                        color =
                                                            primaryColor.toArgb()
                                                    })
                                            val paint = Paint()
                                                .asFrameworkPaint()
                                                .apply {
                                                    isAntiAlias = true
                                                    style =
                                                        android.graphics.Paint.Style.STROKE
                                                    strokeWidth = 2.dp.toPx()
                                                    maskFilter = BlurMaskFilter(
                                                        10f,
                                                        BlurMaskFilter.Blur.NORMAL
                                                    )
                                                    color =
                                                        primaryColor.toArgb()
                                                }
                                            drawCircle(
                                                size.width / 2,
                                                size.width / 2,
                                                (size.width - 12.dp.toPx()) / 2,
                                                paint
                                            )
                                        }
                                    }
                                }
                                .padding(6.dp)
                                .clip(CircleShape)
                                .clickable { },
                            Alignment.Center
                        ) {
                            val icon = screen.icon
                            if (icon != null) {
                                Icon(
                                    icon(),
                                    contentDescription = null,
                                    Modifier.size(24.dp),
                                    tint = MaterialTheme.colors.background
                                )
                            }
                        }
                    } else {
                        Box(
                            Modifier
                                .padding(bottom = 4.dp)
                                .size(40.dp)
                                .clip(CircleShape)
                                .clickable {
                                    navController.navigate(screen.route) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                            Alignment.Center
                        ) {
                            val icon = screen.icon
                            if (icon != null) {
                                Icon(
                                    icon(),
                                    contentDescription = null,
                                    Modifier
                                        .size(28.dp),
                                    tint = if (currentDestination?.hierarchy?.any { it.route == screen.route } == true) Color.White else MaterialTheme.colors.onSurface.copy(
                                        alpha = 0.6f
                                    )
                                )
                            }
                        }
                    }
                }
            }
        },
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Levels.route,
            Modifier
                .padding(bottom = 48.dp),
        ) {
            composable(Screen.Levels.route) { LevelsPage() }
            composable(Screen.Makers.route) { MakersPage() }
            composable(Screen.Add.route) { }
            composable(Screen.Lessons.route) { LessonsPage() }
            composable(Screen.Account.route) { AccountPage() }
        }
    }
}