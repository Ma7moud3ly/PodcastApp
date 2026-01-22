package ma7moud3ly.podcast.core.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// Extracted By ChatGPT from the given screenshot
val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFFF6A3D),          // Orange accent (selected tab, CTA)
    onPrimary = Color(0xFF000000),

    primaryContainer = Color(0xFF3A1A10),
    onPrimaryContainer = Color(0xFFFFDAD0),

    secondary = Color(0xFFFFC107),        // Yellow star / emphasis
    onSecondary = Color(0xFF000000),

    secondaryContainer = Color(0xFF3A3000),
    onSecondaryContainer = Color(0xFFFFECB3),

    background = Color(0xFF0D0D0F),        // App background
    onBackground = Color(0xFFFFFFFF),

    surface = Color(0xFF16161A),           // Main cards
    onSurface = Color(0xFFFFFFFF),

    surfaceVariant = Color(0xFF242428),    // Chips / sections
    onSurfaceVariant = Color(0xFFBDBDBD),

    outline = Color(0xFF3C3C3F),
    outlineVariant = Color(0xFF2A2A2D),

    error = Color(0xFFCF6679),
    onError = Color(0xFF000000)
)

val LightColorScheme = lightColorScheme(
    primary = Color(0xFFFF6A3D),
    onPrimary = Color(0xFFFFFFFF),

    primaryContainer = Color(0xFFFFDAD0),
    onPrimaryContainer = Color(0xFF3A1A10),

    secondary = Color(0xFFFFC107),
    onSecondary = Color(0xFF000000),

    secondaryContainer = Color(0xFFFFECB3),
    onSecondaryContainer = Color(0xFF3A3000),

    background = Color(0xFFF9F9FB),
    onBackground = Color(0xFF1A1A1A),

    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF1A1A1A),

    surfaceVariant = Color(0xFFE6E6EA),
    onSurfaceVariant = Color(0xFF4A4A4F),

    outline = Color(0xFF8E8E93),
    outlineVariant = Color(0xFFD1D1D6),

    error = Color(0xFFB00020),
    onError = Color(0xFFFFFFFF)
)


