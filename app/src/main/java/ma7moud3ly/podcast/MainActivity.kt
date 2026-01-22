package ma7moud3ly.podcast

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import ma7moud3ly.podcast.core.ui.theme.PodcastAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PodcastAppTheme {
                PodcastApp()
            }
        }
    }

    override fun attachBaseContext(base: Context) {
        val config = base.resources.configuration.apply { fontScale = 1f }
        val ctx = base.createConfigurationContext(config)
        super.attachBaseContext(ctx)
    }
}