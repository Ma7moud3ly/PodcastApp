package ma7moud3ly.podcast.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.TextAutoSize
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
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.rememberAsyncImagePainter
import ma7moud3ly.podcast.R
import ma7moud3ly.podcast.core.ui.containers.PreviewBox
import ma7moud3ly.podcast.core.ui.containers.isArabic
import ma7moud3ly.podcast.core.ui.theme.PodcastAppTheme
import ma7moud3ly.podcast.core.domain.model.Podcast
import ma7moud3ly.podcast.core.domain.model.PodcastsSection
import ma7moud3ly.podcast.home.presentation.model.testPodcastsSection
import ma7moud3ly.podcast.home.presentation.model.toDurationString

@Preview
@Composable
private fun SectionPodcastsPreview_Dark() {
    PodcastAppTheme(darkTheme = true) {
        PreviewBox {
            SectionPodcasts(
                section = testPodcastsSection
            )
        }
    }
}

@Preview
@Composable
private fun SectionPodcastsPreview_Light() {
    PodcastAppTheme(darkTheme = false) {
        PreviewBox {
            SectionPodcasts(
                section = testPodcastsSection
            )
        }
    }
}


@Composable
internal fun SectionPodcasts(
    section: PodcastsSection,
    modifier: Modifier = Modifier,
    onShowMore: () -> Unit = {},
    onItemClicked: (Podcast) -> Unit = {}
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
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(section.items, key = { it.id }) { podcast ->
                ItemPodcast(
                    podcast = podcast,
                    modifier = Modifier.width(200.dp),
                    onClick = { onItemClicked(podcast) }
                )
            }
        }
    }
}


@Composable
private fun ItemPodcast(
    podcast: Podcast,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier,
        onClick = onClick,
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop,
                painter = rememberAsyncImagePainter(
                    model = podcast.avatarUrl,
                    error = painterResource(R.drawable.placeholder),
                    placeholder = painterResource(R.drawable.placeholder)
                ),
                contentDescription = podcast.name
            )
            Text(
                text = podcast.name,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                DurationButton(
                    duration = podcast.duration.toDurationString(
                        isArabic = isArabic(),
                        hour = stringResource(R.string.episode_time_h),
                        minute = stringResource(R.string.episode_time_m)
                    )
                )
                BasicText(
                    text = pluralStringResource(
                        R.plurals.episode_count,
                        podcast.episodeCount,
                        podcast.episodeCount
                    ),
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    maxLines = 1,
                    autoSize = TextAutoSize.StepBased(
                        minFontSize = 8.sp,
                        maxFontSize = 12.sp
                    )
                )
            }
        }
    }
}
