package app.smmcommunity.app.android.ui.tabs.makers

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun MakersPage() {
    Box(Modifier.fillMaxSize()) {
        Text(text = "Makers Page", Modifier.align(Alignment.Center))
    }
}

@Preview
@Composable
fun MakersPagePreview() {
    MakersPage()
}