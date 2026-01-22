package ma7moud3ly.podcast.home.data.mapper

import ma7moud3ly.podcast.home.data.model.SectionResponse
import ma7moud3ly.podcast.home.data.model.UnifiedContent
import ma7moud3ly.podcast.core.domain.model.AudioBooksSection
import ma7moud3ly.podcast.core.domain.model.AudioBook

fun SectionResponse.toAudioBookSection() = AudioBooksSection(
    name = name,
    order = order,
    items = content.map { it.toAudiobook() }
)

fun UnifiedContent.toAudiobook() = AudioBook(
    id = audiobookId ?: "",
    name = name,
    authorName = authorName ?: "",
    description = description ?: "",
    avatarUrl = avatarUrl ?: "",
    duration = duration ?: 0,
    language = language ?: "",
    releaseDate = releaseDate ?: "",
    score = score?.toInt() ?: 0
)