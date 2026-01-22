package ma7moud3ly.podcast.core.domain.model

sealed interface Section {
    val name: String
    val order: Int
}

data class PodcastsSection(
    override val name: String,
    override val order: Int,
    val items: List<Podcast>
) : Section

data class EpisodesSection(
    override val name: String,
    override val order: Int,
    val items: List<Episode>
) : Section

data class AudioBooksSection(
    override val name: String,
    override val order: Int,
    val items: List<AudioBook>
) : Section

data class AudioArticlesSection(
    override val name: String,
    override val order: Int,
    val items: List<AudioArticle>
) : Section