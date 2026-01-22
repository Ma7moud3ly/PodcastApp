package ma7moud3ly.podcast.core.domain.model

data class Podcast(
    val id: String,
    val name: String,
    val description: String,
    val avatarUrl: String,
    val episodeCount: Int,
    val duration: Int,
    val score: Double,
    val priority: Int = 0,
    val popularityScore: Int = 0
)
