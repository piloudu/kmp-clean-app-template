package android.template.navigation

import android.os.Bundle
import android.template.feature.main.ui.cat.CatUiModel
import androidx.navigation.NavType
import kotlinx.serialization.json.Json

class NavTypeImpl(isNullableAllowed: Boolean) : NavType<CatUiModel>(isNullableAllowed) {
    override fun get(bundle: Bundle, key: String): CatUiModel? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): CatUiModel {
        val json = Json { ignoreUnknownKeys = true }
        return json.decodeFromString(value)
    }

    override fun put(bundle: Bundle, key: String, value: CatUiModel) {
        return bundle.putParcelable(key, value)
    }
}
