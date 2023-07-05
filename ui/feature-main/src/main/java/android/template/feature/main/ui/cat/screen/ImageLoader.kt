package android.template.feature.main.ui.cat.screen

class ImageLoader private constructor() {
    fun load(url: String) {
    }

    fun into() {
    }

    companion object {

    }
}

val instance = ImageLoader()

fun ImageLoader(config: ImageLoader.() -> Unit): ImageLoader {
    return ImageLoader.instance.apply {
        config()
    }
}
