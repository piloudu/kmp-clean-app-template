package android.template.domain.image

interface Image {
    val url: String
}

class ImageBuilder internal constructor() {
    var url: String = ""

    internal fun build(): ImageImpl {
        return ImageImpl(url)
    }
}

fun Image(builder: ImageBuilder.() -> Unit): Image {
    return ImageBuilder().apply { 
        builder()
    }.build()
}

internal class ImageImpl(override val url: String) : Image
