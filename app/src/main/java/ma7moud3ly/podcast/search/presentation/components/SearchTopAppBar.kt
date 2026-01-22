package ma7moud3ly.podcast.search.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import ma7moud3ly.podcast.R
import ma7moud3ly.podcast.core.ui.theme.PodcastAppTheme

@Preview
@Composable
private fun SearchTopAppBarPreview_Dark() {
    PodcastAppTheme(darkTheme = true) {
        SearchTopAppBar()
    }
}

@Preview
@Composable
private fun SearchTopAppBarPreview_Light() {
    PodcastAppTheme(darkTheme = false) {
        SearchTopAppBar()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTopAppBar(
    onSearch: (String) -> Unit = {},
    onCancel: () -> Unit = {},
    onClear: () -> Unit = {}
) {
    var query by remember { mutableStateOf("") }

    fun clear() {
        query = ""
        onClear()
    }

    // Debounce the search query changes by 500 milliseconds
    LaunchedEffect(query) {
        if (query.isNotBlank()) {
            delay(500)
            onSearch(query)
        }
    }

    TopAppBar(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 8.dp),
        title = {
            ProvideTextStyle(MaterialTheme.typography.bodyMedium) {
                SearchBar(
                    modifier = Modifier.fillMaxWidth(),
                    inputField = {
                        SearchBarDefaults.InputField(
                            modifier = Modifier.height(50.dp),
                            query = query,
                            onQueryChange = { query = it },
                            onSearch = { onSearch(query) },
                            expanded = false,
                            onExpandedChange = { },
                            placeholder = {
                                Text(
                                    text = stringResource(R.string.search_placeholder),
                                    style = MaterialTheme.typography.bodyMedium,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            },
                            leadingIcon = {
                                Icon(
                                    Icons.Default.Search,
                                    contentDescription = null
                                )
                            },
                            trailingIcon = {
                                if (query.isNotEmpty()) {
                                    IconButton(onClick = ::clear) {
                                        Icon(
                                            Icons.Default.Close,
                                            contentDescription = null
                                        )
                                    }
                                }
                            }
                        )
                    },
                    expanded = false,
                    onExpandedChange = { },
                    shape = SearchBarDefaults.inputFieldShape,
                    colors = SearchBarDefaults.colors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    ),
                    content = {}
                )
            }
        },
        navigationIcon = {},
        actions = {
            Surface(
                onClick = onCancel,
                color = Color.Transparent,
                modifier = Modifier.padding(start = 16.dp, end = 8.dp)
            ) {
                Text(
                    text = stringResource(R.string.search_cancel),
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onSurface,
            navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
            actionIconContentColor = MaterialTheme.colorScheme.onSurface
        )
    )
}