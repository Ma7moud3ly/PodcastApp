package ma7moud3ly.podcast.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun appTypography(): Typography {
    val appFontFamily = ibmPlexSansArabic
    return with(MaterialTheme.typography) {
        copy(
            headlineLarge = headlineLarge.copy(fontFamily = appFontFamily),
            headlineMedium = headlineMedium.copy(fontFamily = appFontFamily),
            headlineSmall = headlineSmall.copy(fontFamily = appFontFamily),
            titleLarge = titleLarge.copy(
                fontFamily = appFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 22.sp
            ), titleMedium = titleMedium.copy(
                fontFamily = appFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp
            ),
            titleSmall = titleSmall.copy(
                fontFamily = appFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            ),
            bodyLarge = bodyLarge.copy(
                fontFamily = appFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            ),
            bodyMedium = bodyMedium.copy(
                fontFamily = appFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            ),
            bodySmall = bodySmall.copy(
                fontFamily = appFontFamily,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp
            ),
            labelLarge = labelLarge.copy(
                fontFamily = appFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            ),
            labelMedium = labelMedium.copy(
                fontFamily = appFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp
            ),
            labelSmall = labelSmall.copy(
                fontFamily = appFontFamily,
                fontWeight = FontWeight.ExtraLight,
                fontSize = 11.sp
            )
        )
    }
}