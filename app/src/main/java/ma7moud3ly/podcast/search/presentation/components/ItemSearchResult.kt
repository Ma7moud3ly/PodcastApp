package ma7moud3ly.podcast.search.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import ma7moud3ly.podcast.R
import ma7moud3ly.podcast.core.domain.model.Podcast
import ma7moud3ly.podcast.core.ui.containers.PreviewBox
import ma7moud3ly.podcast.core.ui.theme.PodcastAppTheme
import ma7moud3ly.podcast.search.presentation.model.testSearchPodcastsSection

@Preview
@Composable
fun ItemSearchResultPreview_Dark() {
    PodcastAppTheme(darkTheme = true) {
        PreviewBox {
            ItemSearchResult(testSearchPodcastsSection.items[0])
        }
    }
}

@Preview
@Composable
fun ItemSearchResultPreview_Light() {
    PodcastAppTheme(darkTheme = false) {
        PreviewBox {
            ItemSearchResult(testSearchPodcastsSection.items[0])
        }
    }
}

@Composable
fun ItemSearchResult(
    podcast: Podcast,
    onItemClick: () -> Unit = {}
) {
    Surface(
        onClick = onItemClick,
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop,
                painter = rememberAsyncImagePainter(
                    model = podcast.avatarUrl,
                    error = painterResource(R.drawable.placeholder),
                    placeholder = painterResource(R.drawable.placeholder)
                ),
                contentDescription = podcast.name
            )
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = podcast.name,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = podcast.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}