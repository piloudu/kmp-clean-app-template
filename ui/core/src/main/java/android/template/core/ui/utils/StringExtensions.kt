package android.template.core.ui.utils

import java.util.Locale

fun String.capitalize(): String = replaceFirstChar { char ->
    if (char.isLowerCase()) {
        char.titlecase(
            Locale.getDefault(),
        )
    } else {
        "$char"
    }
}
