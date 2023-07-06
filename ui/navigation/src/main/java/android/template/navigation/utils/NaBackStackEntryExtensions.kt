package android.template.navigation.utils

import androidx.navigation.NavBackStackEntry

fun <T> NavBackStackEntry.parcelableData(key: String): T? {
    return arguments?.getParcelable(key) as? T
}
