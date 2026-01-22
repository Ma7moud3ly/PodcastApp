package ma7moud3ly.podcast.search.presentation.model

import ma7moud3ly.podcast.core.domain.model.AudioArticle
import ma7moud3ly.podcast.core.domain.model.AudioBook
import ma7moud3ly.podcast.core.domain.model.Episode
import ma7moud3ly.podcast.core.domain.model.Podcast

sealed interface SearchEvent {
    data object OnBack : SearchEvent
    data object OnClear : SearchEvent
    data class OnSearch(val query: String) : SearchEvent
    data class OpenPodcast(val podcast: Podcast) : SearchEvent
    data class OpenEpisode(val episode: Episode) : SearchEvent
    data class OpenAudioBook(val audioBook: AudioBook) : SearchEvent
    data class OpenAudioArticle(val audioArticle: AudioArticle) : SearchEvent
}