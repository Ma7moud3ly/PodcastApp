package ma7moud3ly.podcast.home.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ma7moud3ly.podcast.core.ui.theme.PodcastAppTheme

@Preview
@Composable
private fun HomeBottomAppBarPreview_Dark() {
    PodcastAppTheme(darkTheme = true) {
        HomeBottomAppBar()
    }
}

@Preview
@Composable
private fun HomeBottomAppBarPreview_Light() {
    PodcastAppTheme(darkTheme = false) {
        HomeBottomAppBar()
    }
}

@Composable
fun HomeBottomAppBar(
    openSearch: () -> Unit = {}
) {
    var selectedItem by remember { mutableIntStateOf(0) }

    val icons = listOf(
        Icons.Default.Home,
        Icons.Default.Search,
        Icons.Default.Person,
        Icons.AutoMirrored.Filled.List,
        Icons.Default.Settings
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground
    ) {
        icons.forEachIndexed { index, icon ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = { if (index == 1) openSearch() },
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier.size(28.dp)
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedIconColor = MaterialTheme.colorScheme.onSurface,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(
                        alpha = 0.6f
                    )
                )
            )
        }
    }
}

