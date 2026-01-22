package ma7moud3ly.podcast.core.ui.containers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.LayoutDirection

@Composable
fun isArabic(): Boolean = Locale.current.language.contains("ar")


@Composable
fun LayoutDirectionRtl(content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        content()
    }
}

@Composable
fun LayoutDirectionLtr(content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
        content()
    }
}

@Composable
fun LayoutDirectionAny(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalLayoutDirection provides if (isArabic()) LayoutDirection.Rtl
        else LayoutDirection.Ltr
    ) {
        content()
    }
}
