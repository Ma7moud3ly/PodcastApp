package ma7moud3ly.podcast.core.domain.model

data class AudioArticle(
    val id: String,
    val name: String,
    val authorName: String,
    val description: String,
    val duration: Int,
    val releaseDate: String,
    val avatarUrl: String,
    val score: Double
)