package app.smmcommunity.app.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.smmcommunity.app.android.theme.SMMCommunityTheme
import app.smmcommunity.app.android.ui.tabs.account.AccountPage
import app.smmcommunity.app.android.ui.tabs.lessons.LessonsPage
import app.smmcommunity.app.android.ui.tabs.levels.LevelsPage
import app.smmcommunity.app.android.ui.tabs.makers.MakersPage
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            SMMCommunityTheme {
                ProvideWindowInsets {
                    val systemUiController = rememberSystemUiController()
                    val useDarkIcons = MaterialTheme.colors.isLight
                    SideEffect {
                        systemUiController.setStatusBarColor(
                            color = Color.Transparent,
                            darkIcons = useDarkIcons,
                        )
                    }
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            BottomNavigation(
                                backgroundColor = MaterialTheme.colors.background,
                                modifier = Modifier.navigationBarsPadding()
                            ) {
                                val navBackStackEntry by navController.currentBackStackEntryAsState()
                                val currentDestination = navBackStackEntry?.destination
                                screens.forEach { screen ->
                                    BottomNavigationItem(
                                        icon = {
                                            Icon(
                                                painterResource(screen.drawableResId),
                                                contentDescription = null,
                                                Modifier.size(24.dp),
                                            )
                                        },
                                        label = { Text(stringResource(screen.stringResId)) },
                                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                                        onClick = {
                                            navController.navigate(screen.route) {
                                                popUpTo(navController.graph.findStartDestination().id) {
                                                    saveState = true
                                                }
                                                launchSingleTop = true
                                                restoreState = true
                                            }
                                        }
                                    )
                                }
                            }
                        }
                    ) { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = Screen.Levels.route,
                            Modifier.padding(innerPadding),
                        ) {
                            composable("levels") { LevelsPage() }
                            composable("makers") { MakersPage() }
                            composable("lessons") { LessonsPage() }
                            composable("account") { AccountPage() }
                        }
                    }
                }
            }
        }
    }
}
