package android.template.core.ui.utils

import java.util.Locale

fun String.capitalize(): String = this.lowercase().replaceFirstChar { char ->
    char.titlecase(
        Locale.getDefault(),
    )
}
