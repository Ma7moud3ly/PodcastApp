package ma7moud3ly.podcast.home.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ma7moud3ly.podcast.R
import ma7moud3ly.podcast.core.ui.components.ListOfCategories
import ma7moud3ly.podcast.core.ui.containers.PreviewBox
import ma7moud3ly.podcast.core.ui.model.CategoryUiModel
import ma7moud3ly.podcast.core.ui.theme.PodcastAppTheme

@Preview
@Composable
private fun HomeCategoriesPreview_Dark() {
    PodcastAppTheme(darkTheme = true) {
        PreviewBox {
            HomeCategories()
        }
    }
}

@Preview
@Composable
private fun HomeCategoriesPreview_Light() {
    PodcastAppTheme(darkTheme = false) {
        PreviewBox {
            HomeCategories()
        }
    }
}

@Composable
fun HomeCategories(
    modifier: Modifier = Modifier,
    onSelected: (CategoryUiModel) -> Unit = {}
) {
    val categories = remember {
        listOf(
            CategoryUiModel(
                id = 0,
                name = R.string.home_for_you
            ),
            CategoryUiModel(
                id = 1,
                name = R.string.home_podcasts
            ),
            CategoryUiModel(
                id = 2,
                name = R.string.home_episodes
            ),
            CategoryUiModel(
                id = 3,
                name = R.string.home_audio_books
            ),
            CategoryUiModel(
                id = 4,
                name = R.string.home_audio_articles
            )
        )
    }
    ListOfCategories(
        categories = categories,
        modifier = modifier,
        onSelected = onSelected
    )
}

