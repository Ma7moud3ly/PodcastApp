package ma7moud3ly.podcast.search.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResultsResponse(
    @SerialName("sections")
    val results: List<SearchResponse>
)


@Serializable
data class SearchResponse(
    val name: String,
    @SerialName("content_type") private val contentType: String,
    val content: List<SearchContent>
)


@Serializable
data class SearchContent(
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