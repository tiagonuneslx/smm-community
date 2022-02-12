package app.smmcommunity.app.android.ui.tabs.lessons

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LessonsPage() {
    Box(Modifier.fillMaxSize()) {
        Text(text = "Lessons Page", Modifier.align(Alignment.Center))
    }
}

@Preview
@Composable
fun LessonsPagePreview() {
    LessonsPage()
}