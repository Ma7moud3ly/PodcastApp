package ma7moud3ly.podcast.home.data.mapper

import ma7moud3ly.podcast.home.data.model.SectionResponse
import ma7moud3ly.podcast.home.data.model.UnifiedContent
import ma7moud3ly.podcast.core.domain.model.Podcast
import ma7moud3ly.podcast.core.domain.model.PodcastsSection

fun SectionResponse.toPodcastSection() = PodcastsSection(
    name = name,
    order = order,
    items = content.map { it.toPodcast() }
)

fun UnifiedContent.toPodcast() = Podcast(
    id = podcastId ?: "",
    name = name,
    description = description ?: "",
    avatarUrl = avatarUrl ?: "",
    episodeCount = episodeCount ?: 0,
    duration = duration ?: 0,
    score = score ?: 0.0
)