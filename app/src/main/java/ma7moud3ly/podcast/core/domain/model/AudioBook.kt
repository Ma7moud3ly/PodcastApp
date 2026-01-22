package ma7moud3ly.podcast.core.domain.model

data class AudioBook(
    val id: String,
    val name: String,
    val authorName: String,
    val description: String,
    val avatarUrl: String,
    val duration: Int,
    val language: String,
    val releaseDate: String,
    val score: Int
)
