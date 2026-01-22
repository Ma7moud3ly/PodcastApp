package ma7moud3ly.podcast.search.presentation.components

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
private fun SearchCategoriesPreview_Dark() {
    PodcastAppTheme(darkTheme = true) {
        PreviewBox {
            SearchCategories()
        }
    }
}

@Preview
@Composable
private fun SearchCategoriesPreview_Light() {
    PodcastAppTheme(darkTheme = false) {
        PreviewBox {
            SearchCategories()
        }
    }
}

@Composable
fun SearchCategories(
    modifier: Modifier = Modifier,
    onSelected: (CategoryUiModel) -> Unit = {}
) {
    val categories = remember {
        listOf(
            CategoryUiModel(
                id = 0,
                name = R.string.search_cat_all
            ),
            CategoryUiModel(
                id = 1,
                name = R.string.search_cat_episodes
            ),
            CategoryUiModel(
                id = 2,
                name = R.string.search_cat_shows
            ),
            CategoryUiModel(
                id = 3,
                name = R.string.search_cat_people
            ),
            CategoryUiModel(
                id = 4,
                name = R.string.search_cat_audio_books
            ),
            CategoryUiModel(
                id = 5,
                name = R.string.search_cat_articles
            )
        )
    }

    ListOfCategories(
        categories = categories,
        modifier = modifier,
        onSelected = onSelected
    )
}

