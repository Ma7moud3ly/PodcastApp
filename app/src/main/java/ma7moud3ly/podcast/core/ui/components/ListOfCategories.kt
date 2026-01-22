package ma7moud3ly.podcast.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ma7moud3ly.podcast.core.ui.model.CategoryUiModel

@Composable
fun ListOfCategories(
    categories: List<CategoryUiModel>,
    modifier: Modifier = Modifier,
    onSelected: (CategoryUiModel) -> Unit
) {
    var selectedCategory by remember { mutableStateOf(categories.firstOrNull()) }
    val coroutineScope = rememberCoroutineScope()
    val state = rememberLazyListState()

    LazyRow(
        state = state,
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(categories, key = { _, category -> category.id }) { index, category ->
            ItemCategory(
                text = stringResource(category.name),
                selected = { selectedCategory?.id == category.id },
                onSelect = {
                    selectedCategory = category
                    onSelected(category)
                    coroutineScope.launch {
                        state.animateScrollToItem(index)
                    }
                }
            )
        }
    }
}