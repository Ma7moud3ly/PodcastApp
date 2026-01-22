package ma7moud3ly.podcast.home.data.mapper

import ma7moud3ly.podcast.home.data.model.SectionResponse
import ma7moud3ly.podcast.home.data.model.UnifiedContent
import ma7moud3ly.podcast.core.domain.model.Episode
import ma7moud3ly.podcast.core.domain.model.EpisodesSection

fun SectionResponse.toEpisodeSection() = EpisodesSection(
    name = name,
    order = order,
    items = content.map { it.toEpisode() }
)

fun UnifiedContent.toEpisode() = Episode(
    id = episodeId ?: "",
    name = name ?: "",
    episodeType = episodeType ?: "",
    podcastName = podcastName ?: "",
    duration = duration ?: 0,
    avatarUrl = avatarUrl ?: "",
    audioUrl = audioUrl ?: "",
    releaseDate = releaseDate ?: "",
    score = score ?: 0.0
)