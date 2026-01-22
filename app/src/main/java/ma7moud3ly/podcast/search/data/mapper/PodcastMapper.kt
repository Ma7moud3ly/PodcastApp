package ma7moud3ly.podcast.search.data.mapper

import ma7moud3ly.podcast.search.data.model.SearchContent
import ma7moud3ly.podcast.core.domain.model.Podcast
import ma7moud3ly.podcast.core.domain.model.PodcastsSection
import ma7moud3ly.podcast.search.data.model.SearchResponse

fun SearchResponse.toPodcastSection() = PodcastsSection(
    name = name,
    order = 0,
    items = content.map { it.toPodcast() }
)

fun SearchContent.toPodcast() = Podcast(
    id = podcastId ?: "",
    name = name,
    description = description ?: "",
    avatarUrl = avatarUrl ?: "",
    episodeCount = episodeCount ?: 0,
    duration = duration ?: 0,
    score = 0.0
)