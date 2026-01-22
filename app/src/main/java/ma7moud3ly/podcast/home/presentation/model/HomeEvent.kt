package ma7moud3ly.podcast.home.presentation.model

import ma7moud3ly.podcast.core.domain.model.AudioArticle
import ma7moud3ly.podcast.core.domain.model.AudioBook
import ma7moud3ly.podcast.core.domain.model.Episode
import ma7moud3ly.podcast.core.domain.model.Podcast

sealed interface HomeEvent {
    data object OpenSearch : HomeEvent
    data object OpenPodcasts : HomeEvent
    data object OpenEpisodes : HomeEvent
    data object OpenAudioBooks : HomeEvent
    data object OpenAudioArticles : HomeEvent
    data class OpenPodcast(val podcast: Podcast) : HomeEvent
    data class OpenEpisode(val episode: Episode) : HomeEvent
    data class OpenAudioBook(val audioBook: AudioBook) : HomeEvent
    data class OpenAudioArticle(val audioArticle: AudioArticle) : HomeEvent
}