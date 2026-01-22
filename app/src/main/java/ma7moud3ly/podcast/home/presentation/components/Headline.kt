package ma7moud3ly.podcast.home.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun SectionHeadline(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.onSurface,
    onMore: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleLarge,
            color = color
        )
        Spacer(Modifier.weight(1f))
        IconButton(onClick = onMore) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}