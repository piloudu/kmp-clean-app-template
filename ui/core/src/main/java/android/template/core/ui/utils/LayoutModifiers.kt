package android.template.core.ui.utils

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout

val loadingLayoutModifier: Modifier = Modifier.layout { measurable, constraints ->
    val placeable = measurable.measure(
        constraints.copy(
            minWidth = 20,
            maxWidth = 80,
            minHeight = 20,
            maxHeight = 80,
        ),
    )
    layout(
        width = constraints.maxWidth,
        height = constraints.maxHeight,
    ) {
        placeable.place(
            x = (constraints.maxWidth / 2) - (placeable.width / 2),
            y = (constraints.maxWidth / 2) - (placeable.height / 2),
        )
    }
}
