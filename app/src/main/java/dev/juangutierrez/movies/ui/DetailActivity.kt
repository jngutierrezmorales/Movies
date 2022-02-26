package dev.juangutierrez.movies.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.juangutierrez.movies.R
import dev.juangutierrez.movies.model.Movie
import dev.juangutierrez.movies.utils.loadImage
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    private var movie: Movie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        retrieveMovie()
        renderUi()
    }

    private fun retrieveMovie() {
        movie = intent.getSerializableExtra("movie") as Movie?
    }

    private fun renderUi() {
        detailName.text = movie?.name
        detailDescription.text = movie!!.description
        movie?.cover?.let { mCover ->
            detailImage.loadImage(mCover)
        }
    }
}