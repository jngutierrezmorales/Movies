package dev.juangutierrez.movies.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import com.bumptech.glide.Glide
import java.io.InputStream
import java.lang.Exception
import java.nio.charset.Charset

fun Context.getJsonFromAssets(file: String): String? {
    var json: String? = null

    try {
        val stream: InputStream = assets.open(file)
        val size: Int = stream.available()
        val buffer = ByteArray(size)
        stream.read(buffer)
        stream.close()

        json = String(buffer, Charset.defaultCharset())
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return json
}

fun ImageView.loadImage(image: String) {
    Glide.with(this)
        .load(image)
        .into(this)
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = true): View =
    LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)