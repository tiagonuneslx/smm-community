package app.smmcommunity.app.android.tabs.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.smmcommunity.app.Greeting

fun greet(): String {
    return Greeting().greeting()
}

@Composable
fun LevelsPage() {
    Box(Modifier.fillMaxSize()) {
        Text(greet(), Modifier.align(Alignment.Center))
    }
}

@Preview
@Composable
fun LevelsPagePreview() {
    LevelsPage()
}