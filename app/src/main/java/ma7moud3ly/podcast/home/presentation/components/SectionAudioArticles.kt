package ma7moud3ly.podcast.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil3.compose.rememberAsyncImagePainter
import ma7moud3ly.podcast.R
import ma7moud3ly.podcast.core.ui.containers.PreviewBox
import ma7moud3ly.podcast.core.ui.containers.isArabic
import ma7moud3ly.podcast.core.ui.theme.PodcastAppTheme
import ma7moud3ly.podcast.core.domain.model.AudioArticle
import ma7moud3ly.podcast.core.domain.model.AudioArticlesSection
import ma7moud3ly.podcast.home.presentation.model.testAudioArticlesSection
import ma7moud3ly.podcast.home.presentation.model.toDurationString

@Preview
@Composable
private fun SectionAudioArticlesPreview_Dark() {
    PodcastAppTheme(darkTheme = true) {
        PreviewBox {
            SectionAudioArticles(
                section = testAudioArticlesSection
            )
        }
    }
}

@Preview
@Composable
private fun SectionAudioArticlesPreview_Light() {
    PodcastAppTheme(darkTheme = false) {
        PreviewBox {
            SectionAudioArticles(
                section = testAudioArticlesSection
            )
        }
    }
}


@Composable
internal fun SectionAudioArticles(
    section: AudioArticlesSection,
    modifier: Modifier = Modifier,
    onShowMore: () -> Unit = {},
    onItemClicked: (AudioArticle) -> Unit = {}
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
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(section.items) { audioArticle ->
                ItemAudioArticle(
                    audioArticle = audioArticle,
                    modifier = Modifier
                        .height(180.dp)
                        .width(220.dp),
                    onClick = { onItemClicked(audioArticle) }
                )
            }
        }
    }
}


@Composable
private fun ItemAudioArticle(
    audioArticle: AudioArticle,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        color = Color.Transparent,
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier.fillMaxSize().alpha(0.8f),
                contentScale = ContentScale.Crop,
                painter = rememberAsyncImagePainter(
                    model = audioArticle.avatarUrl,
                    error = painterResource(R.drawable.placeholder),
                    placeholder = painterResource(R.drawable.placeholder)
                ),
                contentDescription = audioArticle.name
            )
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .zIndex(2f)
                    .align(Alignment.BottomStart)
            ) {
                Text(
                    text = audioArticle.name,
                    style = MaterialTheme.typography.titleLarge.copy(
                        shadow = Shadow(
                            color = MaterialTheme.colorScheme.background,
                            offset = Offset(2f, 2f),
                            blurRadius = 4f
                        )
                    ),
                    color =MaterialTheme.colorScheme.onSurface,
                    maxLines = 2
                )
                DurationButton(
                    duration = audioArticle.duration.toDurationString(
                        isArabic = isArabic(),
                        hour = stringResource(R.string.episode_time_h),
                        minute = stringResource(R.string.episode_time_m)
                    ),
                    backgroundColor = MaterialTheme.colorScheme.surfaceVariant.copy(
                        alpha = 0.5f
                    )
                )
            }
        }
    }
}
