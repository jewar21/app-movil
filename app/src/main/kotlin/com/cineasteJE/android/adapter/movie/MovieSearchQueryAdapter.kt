package com.cineasteJE.android.adapter.movie

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.cineasteJE.android.R
import com.cineasteJE.android.entity.movie.Movie
import com.cineasteJE.android.listener.ItemClickListener
import com.cineasteJE.android.viewholder.movie.MovieSearchViewHolder

class MovieSearchQueryAdapter(
    private val listener: ItemClickListener
) : RecyclerView.Adapter<MovieSearchViewHolder>() {
    private val dataSet = ArrayList<Movie>()

    fun addMovies(movies: List<Movie>) {
        dataSet.clear()
        dataSet.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieSearchViewHolder {
        val v = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.card_search, parent, false)
        return MovieSearchViewHolder(v, parent.context, listener)
    }

    override fun onBindViewHolder(holder: MovieSearchViewHolder, position: Int) {
        holder.assignData(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
