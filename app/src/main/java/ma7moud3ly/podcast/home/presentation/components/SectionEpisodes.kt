package ma7moud3ly.podcast.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import ma7moud3ly.podcast.R
import ma7moud3ly.podcast.core.ui.containers.PreviewBox
import ma7moud3ly.podcast.core.ui.containers.isArabic
import ma7moud3ly.podcast.core.ui.theme.PodcastAppTheme
import ma7moud3ly.podcast.core.domain.model.Episode
import ma7moud3ly.podcast.core.domain.model.EpisodesSection
import ma7moud3ly.podcast.home.presentation.model.releaseDateAgo
import ma7moud3ly.podcast.home.presentation.model.testEpisodesSection
import ma7moud3ly.podcast.home.presentation.model.toDurationString

@Preview
@Composable
private fun SectionEpisodesPreview_Dark() {
    PodcastAppTheme(darkTheme = true) {
        PreviewBox {
            SectionEpisodes(
                section = testEpisodesSection
            )
        }
    }
}

@Preview
@Composable
private fun SectionEpisodesPreview_Light() {
    PodcastAppTheme(darkTheme = false) {
        PreviewBox {
            SectionEpisodes(
                section = testEpisodesSection
            )
        }
    }
}

private val episodesListHeight = 240.dp
private val episodeItemWidth = 320.dp

@Composable
internal fun SectionEpisodes(
    section: EpisodesSection,
    modifier: Modifier = Modifier,
    onShowMore: () -> Unit = {},
    onItemClicked: (Episode) -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        SectionHeadline(
            text = section.name,
            color = MaterialTheme.colorScheme.onSurface,
            onMore = onShowMore
        )

        LazyHorizontalGrid(
            modifier = Modifier
                .fillMaxWidth()
                .height(episodesListHeight),
            rows = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(section.items, key = { it.id }) { episode ->
                ItemEpisode(
                    episode = episode,
                    modifier = Modifier.width(episodeItemWidth),
                    onClick = { onItemClicked(episode) }
                )
            }
        }
    }
}


@Composable
private fun ItemEpisode(
    episode: Episode,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        color = Color.Transparent,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop,
                painter = rememberAsyncImagePainter(
                    model = episode.avatarUrl,
                    error = painterResource(R.drawable.placeholder),
                    placeholder = painterResource(R.drawable.placeholder)
                ),
                contentDescription = episode.name
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = episode.releaseDateAgo(),
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = episode.name,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onSurface,
                    minLines = 2,
                    maxLines = 2,
                    modifier = Modifier.weight(1f)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(0.dp)
                ) {
                    DurationButton(
                        duration = episode.duration.toDurationString(
                            isArabic = isArabic(),
                            hour = stringResource(R.string.episode_time_h),
                            minute = stringResource(R.string.episode_time_m)
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(
                        onClick = {},
                        colors = IconButtonDefaults.iconButtonColors(
                            contentColor = MaterialTheme.colorScheme.onSurface
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp)
                                .rotate(90f)
                        )
                    }
                    IconButton(
                        onClick = {},
                        colors = IconButtonDefaults.iconButtonColors(
                            contentColor = MaterialTheme.colorScheme.onSurface
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }
    }
}
