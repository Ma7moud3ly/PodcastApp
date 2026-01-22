package ma7moud3ly.podcast.home.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NotificationBadgeIcon(
    count: Int,
    modifier: Modifier = Modifier
) {
    BadgedBox(
        modifier = modifier,
        badge = {
            if (count > 0) {
                Badge(contentColor = Color.White) {
                    val displayCount = if (count > 99) "99+" else count.toString()
                    Text(
                        text = displayCount,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    ) {
        Icon(
            imageVector = Icons.Outlined.Notifications,
            contentDescription = "Notifications",
            modifier = Modifier.size(32.dp)
        )
    }
}