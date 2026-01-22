package ma7moud3ly.podcast.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import ma7moud3ly.podcast.R
import ma7moud3ly.podcast.core.ui.containers.PreviewBox
import ma7moud3ly.podcast.core.ui.theme.PodcastAppTheme
import ma7moud3ly.podcast.core.domain.model.AudioBook
import ma7moud3ly.podcast.core.domain.model.AudioBooksSection
import ma7moud3ly.podcast.home.presentation.model.testAudioBooksSection

@Preview
@Composable
private fun SectionAudioBooksPreview_Dark() {
    PodcastAppTheme(darkTheme = true) {
        PreviewBox {
            SectionAudioBooks(
                section = testAudioBooksSection
            )
        }
    }
}

@Preview
@Composable
private fun SectionAudioBooksPreview_Light() {
    PodcastAppTheme(darkTheme = false) {
        PreviewBox {
            SectionAudioBooks(
                section = testAudioBooksSection
            )
        }
    }
}


@Composable
internal fun SectionAudioBooks(
    section: AudioBooksSection,
    modifier: Modifier = Modifier,
    onShowMore: () -> Unit = {},
    onItemClicked: (AudioBook) -> Unit = {}
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
            items(section.items) { audioBook ->
                ItemAudioBook(
                    audioBook = audioBook,
                    modifier = Modifier.size(150.dp),
                    onClick = { onItemClicked(audioBook) }
                )
            }
        }
    }
}


@Composable
private fun ItemAudioBook(
    audioBook: AudioBook,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        color = Color.Transparent,
        modifier = modifier
    ) {
        Image(
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop,
            painter = rememberAsyncImagePainter(
                model = audioBook.avatarUrl,
                error = painterResource(R.drawable.placeholder),
                placeholder = painterResource(R.drawable.placeholder)
            ),
            contentDescription = audioBook.name
        )
    }
}
