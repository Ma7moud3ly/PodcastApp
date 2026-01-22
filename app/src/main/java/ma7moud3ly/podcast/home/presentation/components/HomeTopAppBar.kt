package ma7moud3ly.podcast.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ma7moud3ly.podcast.R
import ma7moud3ly.podcast.core.ui.theme.PodcastAppTheme

@Preview
@Composable
private fun HomeTopAppBarPreview_Dark() {
    PodcastAppTheme(darkTheme = true) {
        HomeTopAppBar()
    }
}

@Preview
@Composable
private fun HomeTopAppBarPreview_Light() {
    PodcastAppTheme(darkTheme = false) {
        HomeTopAppBar()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar(
    openNotifications: () -> Unit = {}
) {
    TopAppBar(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 8.dp),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = stringResource(R.string.home_welcome, "Ali"),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 8.dp),
                    maxLines = 1
                )
                Text(
                    text = "\uD83C\uDF1F",
                    style = MaterialTheme.typography.titleSmall,
                )
            }
        },
        navigationIcon = {
            Image(
                painter = painterResource(R.drawable.user),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .alpha(0.6f)
            )
        },
        actions = {
            NotificationBadgeIcon(
                count = 3,
                modifier = Modifier.clickable { openNotifications() }
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onSurface,
            navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
            actionIconContentColor = MaterialTheme.colorScheme.onSurface
        )
    )
}

