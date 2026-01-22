package ma7moud3ly.podcast.home.presentation.model

import androidx.compose.runtime.Composable
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import ma7moud3ly.podcast.core.domain.model.AudioArticle
import ma7moud3ly.podcast.core.domain.model.AudioArticlesSection
import ma7moud3ly.podcast.core.domain.model.AudioBooksSection
import ma7moud3ly.podcast.core.domain.model.AudioBook
import ma7moud3ly.podcast.core.domain.model.Episode
import ma7moud3ly.podcast.core.domain.model.EpisodesSection
import ma7moud3ly.podcast.core.domain.model.Podcast
import ma7moud3ly.podcast.core.domain.model.PodcastsSection
import ma7moud3ly.podcast.core.domain.model.Section


val testPodcastsSection = PodcastsSection(
    name = "Podcasts",
    order = 1,
    items = listOf(
        Podcast(
            id = "33223131",
            name = "NPR News Now",
            description = "The latest news in five minutes. Updated hourly.",
            avatarUrl = "https://media.npr.org/assets/img/2023/03/01/npr-news-now_square.png?s=1400&c=66",
            episodeCount = 2,
            duration = 600,
            priority = 1,
            popularityScore = 11,
            score = 240.0845
        ),
        Podcast(
            id = "1222114325",
            name = "Up First from NPR",
            description = "The three biggest stories of the day.",
            avatarUrl = "https://media.npr.org/assets/img/2022/09/23/up-first_tile_npr-network-01_sq.jpg",
            episodeCount = 500,
            duration = 1800,
            priority = 2,
            popularityScore = 9,
            score = 217.26
        )
    )
)

val testEpisodesSection = EpisodesSection(
    name = "Episodes",
    order = 2,
    items = listOf(
        Episode(
            id = "2512aa1f-8a51-516a-a59b-ec32870c1f4b",
            name = "NPR News: 07-27-2024 12AM EDT",
            episodeType = "full",
            podcastName = "NPR News Now",
            duration = 300,
            avatarUrl = "https://media.npr.org/assets/img/2023/03/01/npr-news-now_square.png?s=1400&c=66",
            audioUrl = "https://example.com/audio1.mp3",
            releaseDate = "2024-07-27T04:00:00.000Z",
            score = 214.18
        ),
        Episode(
            id = "ep_002",
            name = "Morning Briefing",
            episodeType = "full",
            podcastName = "Up First",
            duration = 600,
            avatarUrl = "https://media.npr.org/assets/img/2022/09/23/up-first_tile_npr-network-01_sq.jpg",
            audioUrl = "https://example.com/audio2.mp3",
            releaseDate = "2024-07-28T06:30:00.000Z",
            score = 198.4
        )
    )
)


val testAudioBooksSection = AudioBooksSection(
    name = "Audiobooks",
    order = 3,
    items = listOf(
        AudioBook(
            id = "audiobook_001",
            name = "The Art of War",
            authorName = "Sun Tzu",
            description = "An ancient military text on strategy and tactics.",
            avatarUrl = "https://i.scdn.co/image/ab67616d00001e02ff9ca10b55ce82ae553c8228",
            duration = 36000,
            language = "en",
            releaseDate = "2023-01-10T08:00:00Z",
            score = 500
        ),
        AudioBook(
            id = "audiobook_002",
            name = "Atomic Habits",
            authorName = "James Clear",
            description = "An easy & proven way to build good habits.",
            avatarUrl = "https://i.scdn.co/image/ab67616d00001e02atomic",
            duration = 42000,
            language = "en",
            releaseDate = "2022-05-01T08:00:00Z",
            score = 480
        )
    )
)

val testAudioArticlesSection = AudioArticlesSection(
    name = "Audio Articles",
    order = 4,
    items = listOf(
        AudioArticle(
            id = "audiobook_001",
            name = "The Art of War",
            authorName = "Sun Tzu",
            description = "An ancient military text on strategy and tactics.",
            avatarUrl = "https://i.scdn.co/image/ab67616d00001e02ff9ca10b55ce82ae553c8228",
            duration = 36000,
            releaseDate = "2023-01-10T08:00:00Z",
            score = 500.0
        ),
        AudioArticle(
            id = "audiobook_002",
            name = "Atomic Habits",
            authorName = "James Clear",
            description = "An easy & proven way to build good habits.",
            avatarUrl = "https://i.scdn.co/image/ab67616d00001e02atomic",
            duration = 42000,
            releaseDate = "2022-05-01T08:00:00Z",
            score = 500.0
        )
    )
)


val testSections = listOf(
    testPodcastsSection,
    testEpisodesSection,
    testAudioBooksSection,
    testAudioArticlesSection
)

@Composable
fun testPagingFlow(): Flow<PagingData<Section>> = flowOf(PagingData.from(testSections))