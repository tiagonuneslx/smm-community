package app.smmcommunity.app.android.ui.tabs.levels

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.smmcommunity.app.android.R
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun LevelsPage() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {
//        Column(
//            Modifier
//                .clip(RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp))
//                .background(MaterialTheme.colors.primary)
//                .fillMaxWidth()
//        ) {
//            Spacer(Modifier.statusBarsHeight())
//            Spacer(Modifier.height(20.dp))
//            Image(
//                painter = painterResource(id = R.drawable.ic_logo),
//                contentDescription = null,
//                Modifier
//                    .padding(horizontal = 8.dp)
//                    .width(240.dp),
//            )
//            Spacer(Modifier.height(4.dp))
//        }
        Spacer(Modifier.height(16.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .padding(start = 24.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Levels",
                style = MaterialTheme.typography.h1,
                color = Color.White
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable { }) {
                Box(
                    Modifier
                        .size(40.dp)
                        .alpha(0.2f)
                        .background(MaterialTheme.colors.onBackground)
                ) {}
                Icon(
                    Icons.Default.Search,
                    "Search",
                    tint = MaterialTheme.colors.onBackground,
                    modifier = Modifier.size(28.dp)
                )
            }
        }
        Spacer(Modifier.height(20.dp))
        Text(
            text = "Recommended Levels",
            modifier = Modifier.padding(horizontal = 16.dp),
            fontWeight = FontWeight.Bold,
        )
        Spacer(Modifier.height(16.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(2) {
                Image(
                    painter = painterResource(R.drawable.level_placeholder),
                    contentDescription = null,
                    Modifier
                        .width(240.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .clickable { }
                )
            }
        }
        Spacer(Modifier.height(20.dp))
        Text(
            text = "Popular Levels",
            modifier = Modifier.padding(horizontal = 16.dp),
            fontWeight = FontWeight.Bold,
        )
        Spacer(Modifier.height(16.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(2) {
                Image(
                    painter = painterResource(R.drawable.level_placeholder),
                    contentDescription = null,
                    Modifier
                        .width(240.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .clickable { }
                )
            }
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Preview
@Composable
fun LevelsPagePreview() {
    LevelsPage()
}