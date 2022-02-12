package app.smmcommunity.app.android.ui.tabs.levels

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.smmcommunity.app.android.R
import com.google.accompanist.insets.statusBarsHeight

@Composable
fun LevelsPage() {
    Box(Modifier.fillMaxSize()) {
        Column(
            Modifier
                .clip(RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp))
                .background(MaterialTheme.colors.primary)
                .fillMaxWidth()
        ) {
            Spacer(Modifier.statusBarsHeight())
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = null,
                Modifier
                    .padding(vertical = 16.dp)
                    .width(240.dp)
                    .align(Alignment.CenterHorizontally),
            )
        }
    }
}

@Preview
@Composable
fun LevelsPagePreview() {
    LevelsPage()
}