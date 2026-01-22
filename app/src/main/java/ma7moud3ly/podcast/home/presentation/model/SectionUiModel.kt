package ma7moud3ly.podcast.home.presentation.model

import ma7moud3ly.podcast.core.domain.model.Episode
import java.time.Duration
import java.time.Instant
import java.util.concurrent.TimeUnit

fun Int.toDurationString(
    isArabic: Boolean = false,
    minute: String = "m",
    hour: String = "h",
): String {
    val totalSeconds = this.toLong()
    val hours = TimeUnit.SECONDS.toHours(totalSeconds)
    val minutes = TimeUnit.SECONDS.toMinutes(totalSeconds) % 60

    return if (isArabic) {
        when {
            hours > 0 && minutes > 0 -> "${hours}$hour ${minutes}$minute"
            hours > 0 -> "${hours}$hour"
            else -> "${minutes}$minute"
        }
    } else {
        when {
            hours > 0 && minutes > 0 -> "${hours}:${minutes.toString().padStart(2, '0')} $hour"
            hours > 0 -> "$hours $hour"
            else -> "$minutes $minute"
        }
    }
}



fun Episode.releaseDateAgo(): String {
    return try {
        val instant = Instant.parse(this.releaseDate)
        val now = Instant.now()
        val duration = Duration.between(instant, now)

        val seconds = duration.seconds
        val minutes = seconds / 60
        val hours = minutes / 60
        val days = hours / 24
        val months = days / 30
        val years = days / 365

        when {
            seconds < 60 -> "just now"
            minutes < 60 -> "$minutes minutes ago"
            hours == 1L -> "an hour ago"
            hours < 24 -> "$hours hours ago"
            days == 1L -> "yesterday"
            days < 7 -> "$days days ago"
            days < 30 -> "${days / 7} weeks ago"
            months == 1L -> "last month"
            months < 12 -> "$months months ago"
            years == 1L -> "last year"
            else -> "$years years ago"
        }
    } catch (e: Exception) {
        releaseDate
    }
}