package app.smmcommunity.app.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.smmcommunity.app.android.Screen
import app.smmcommunity.app.android.theme.Grey950
import app.smmcommunity.app.android.theme.SMMCommunityTheme
import app.smmcommunity.app.android.ui.login.LoginPage
import app.smmcommunity.app.android.ui.tabs.Tabs
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay

@Composable
fun App() {
    SMMCommunityTheme {
        ProvideWindowInsets {
            val systemUiController = rememberSystemUiController()
            val isDark = isSystemInDarkTheme()
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = Color.Transparent,
                    darkIcons = !isDark,
                )
                systemUiController.setNavigationBarColor(
                    color = Color.Black,
                    darkIcons = !isDark,
                )
            }
            LaunchedEffect(isDark) {
                if (isDark) {
                    systemUiController.setNavigationBarColor(color = Grey950)
                }
            }
            val navController = rememberNavController()
            LaunchedEffect(Unit) {
                delay(5000)
                navController.navigate(Screen.Tabs.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            }
            Box(
                Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
            ) {
                NavHost(
                    navController = navController,
                    startDestination = Screen.Login.route,
                    Modifier
                        .padding(bottom = 48.dp),
                ) {
                    composable(Screen.Login.route) { LoginPage() }
                    composable(Screen.Tabs.route) { Tabs(systemUiController) }
                }
            }
        }
    }
}