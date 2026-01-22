package ma7moud3ly.podcast.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ma7moud3ly.podcast.core.ui.theme.PodcastAppTheme


@Preview
@Composable
private fun SectionCategoriesPreview_Dark() {
    PodcastAppTheme(darkTheme = true) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp)
        ) {
            ItemCategory(
                text = "Podcasts",
                selected = { true },
                onSelect = {}
            )
            ItemCategory(
                text = "Episodes",
                selected = { false },
                onSelect = {}
            )
        }
    }
}

@Composable
fun ItemCategory(
    text: String,
    selected: () -> Boolean,
    modifier: Modifier = Modifier,
    onSelect: () -> Unit
) {
    val selected = selected()

    FilterChip(
        selected = selected,
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        border = null,
        elevation = null,
        onClick = onSelect,
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = MaterialTheme.colorScheme.primary,
            selectedLabelColor = Color.White,
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            labelColor = MaterialTheme.colorScheme.onSurface
        ),
        label = {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(
                    horizontal = 0.dp,
                    vertical = 8.dp
                )
            )
        }
    )
}