package ma7moud3ly.podcast.home.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SectionsResponse(
    val sections: List<SectionResponse>
)


@Serializable
data class SectionResponse(
    val name: String,
    @SerialName("content_type") private val contentType: String,
    val order: Int,
    val content: List<UnifiedContent>
) {
    fun getContentType(): ContentType? {
        return when (contentType) {
            "podcast" -> ContentType.PODCAST
            "episode" -> ContentType.EPISODE
            "audio_book" -> ContentType.AUDIO_BOOK
            "audio_article" -> ContentType.AUDIO_ARTICLE
            else -> null
        }
    }
}

enum class ContentType {
    PODCAST, EPISODE, AUDIO_BOOK, AUDIO_ARTICLE
}


@Serializable
data class UnifiedContent(
    @SerialName("podcast_id")
    val podcastId: String? = null,
    @SerialName("episode_id")
    val episodeId: String? = null,
    @SerialName("audiobook_id")
    val audiobookId: String? = null,
    @SerialName("article_id")
    val articleId: String? = null,

    val name: String,
    val description: String? = null,
    val score: Double? = null,
    @SerialName("avatar_url") val avatarUrl: String? = null,
    val duration: Int? = null,

    @SerialName("episode_count") val episodeCount: Int? = null,
    @SerialName("episode_type") val episodeType: String? = null,
    @SerialName("audio_url") val audioUrl: String? = null,
    @SerialName("release_date") val releaseDate: String? = null,
    @SerialName("author_name") val authorName: String? = null,
    @SerialName("podcast_name") val podcastName: String? = null,
    val language: String? = null
)