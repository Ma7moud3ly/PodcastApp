package ma7moud3ly.podcast.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ma7moud3ly.podcast.core.ui.containers.isArabic
import ma7moud3ly.podcast.core.ui.theme.PodcastAppTheme
import ma7moud3ly.podcast.home.presentation.model.toDurationString

@Preview(locale = "ar")
@Composable
private fun DurationButtonPreview_Arabic() {
    val duration = 610.toDurationString(
        isArabic = isArabic(),
        minute = "د",
        hour = "س"
    )
    PodcastAppTheme {
        DurationButton(duration = duration)
    }
}

@Preview
@Composable
private fun DurationButtonPreview() {
    val duration = 610.toDurationString(
        isArabic = isArabic(),
        minute = "m",
        hour = "h"
    )
    PodcastAppTheme {
        DurationButton(duration = duration)
    }
}

@Composable
fun DurationButton(
    duration: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceVariant
) {
    Surface(
        modifier = modifier,
        color = backgroundColor,
        shape = RoundedCornerShape(24.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                tint =  MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = duration,
                style = MaterialTheme.typography.labelMedium,
                color =  MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

