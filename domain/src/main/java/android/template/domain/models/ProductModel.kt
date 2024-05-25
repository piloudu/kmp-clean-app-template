package android.template.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class ProductModel(
    val name: String,
    val price: Price
) : Serializable, Parcelable

@Parcelize
@JvmInline
value class Price(val value: Double?) : Serializable, Parcelable
