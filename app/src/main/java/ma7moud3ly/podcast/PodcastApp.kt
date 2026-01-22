package ma7moud3ly.podcast

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import ma7moud3ly.podcast.home.presentation.HomeScreen
import ma7moud3ly.podcast.search.presentation.SearchScreen

data object Home
data object Search

@Composable
fun PodcastApp() {

    val backStack = remember { mutableStateListOf<Any>(Home) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is Home -> NavEntry(key) {
                    HomeScreen(
                        navigateToSearch = { backStack.add(Search) }
                    )
                }

                is Search -> NavEntry(key) {
                    SearchScreen(
                        onBack = { backStack.removeLastOrNull() }
                    )
                }

                else -> NavEntry(Unit) {}
            }
        }
    )
}