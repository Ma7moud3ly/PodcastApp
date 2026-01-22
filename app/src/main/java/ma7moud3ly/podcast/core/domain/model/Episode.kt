package ma7moud3ly.podcast.core.domain.model

data class Episode(
    val id: String,
    val name: String,
    val episodeType: String,
    val podcastName: String,
    val duration: Int,
    val avatarUrl: String,
    val audioUrl: String,
    val releaseDate: String,
    val score: Double
)
