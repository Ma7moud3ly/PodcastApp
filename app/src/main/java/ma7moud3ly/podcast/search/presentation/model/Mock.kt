package ma7moud3ly.podcast.search.presentation.model

import ma7moud3ly.podcast.core.domain.model.Podcast
import ma7moud3ly.podcast.core.domain.model.PodcastsSection

val testSearchPodcastsSection = PodcastsSection(
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

val testSearchResults = listOf(testSearchPodcastsSection)