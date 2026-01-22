package ma7moud3ly.podcast.home.data.mapper

import ma7moud3ly.podcast.home.data.model.SectionResponse
import ma7moud3ly.podcast.home.data.model.UnifiedContent
import ma7moud3ly.podcast.core.domain.model.AudioArticle
import ma7moud3ly.podcast.core.domain.model.AudioArticlesSection

fun SectionResponse.toAudioArticleSection() = AudioArticlesSection(
    name = name,
    order = order,
    items = content.map { it.toAudioArticle() }
)

fun UnifiedContent.toAudioArticle() = AudioArticle(
    id = articleId ?: "",
    name = name,
    authorName = authorName ?: "",
    description = description ?: "",
    duration = duration ?: 0,
    releaseDate = releaseDate ?: "",
    avatarUrl = avatarUrl ?: "",
    score = score ?: 0.0
)