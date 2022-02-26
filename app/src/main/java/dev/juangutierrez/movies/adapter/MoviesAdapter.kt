package dev.juangutierrez.movies.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.juangutierrez.movies.R
import dev.juangutierrez.movies.model.Movie
import dev.juangutierrez.movies.utils.inflate
import java.util.*
import kotlin.collections.ArrayList

class MoviesAdapter(private val listener: (Movie) -> Unit) :
    RecyclerView.Adapter<MoviesViewHolder>() {
    private val movieList = arrayListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = parent.inflate(R.layout.item_movie, false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener { listener(movie) }
    }

    fun refreshList(movieList: ArrayList<Movie>) {
        this.movieList.addAll(movieList)
        notifyDataSetChanged()
    }

    fun filterByName(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
        notifyDataSetChanged()
    }

    fun orderByName() {
        val sortedList = movieList.sortedBy { it.name }
        val reverseSortedList = sortedList.reversed()
        movieList.clear()
        movieList.addAll(reverseSortedList)
        notifyDataSetChanged()
    }

    fun insertObject() {
        val item = Movie(13, "Prueba", "Prueba", "https://image.tmdb.org/t/p/original//dRZpdpKLgN9nk57zggJCs1TjJb4.jpg", 1972)
        movieList.add(0, item)
        notifyItemInserted(0)
    }

    fun modifyObject() {
//        movieList[0].name = "Prueba"
        notifyItemChanged(0)
    }

    fun deleteObject() {
        movieList.removeAt(0)
        notifyItemRemoved(0)
    }
}