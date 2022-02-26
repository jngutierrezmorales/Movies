package dev.juangutierrez.movies.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dev.juangutierrez.movies.model.Movie
import dev.juangutierrez.movies.utils.loadImage
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(movie: Movie) {
        itemView.movieTitle.text = movie.name
        movie.cover?.let { mMovie ->
            itemView.movieCover.loadImage(mMovie)
        }
    }
}