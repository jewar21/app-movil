package com.cineasteJE.android.viewholder.movie

import android.content.Context
import android.graphics.Color
import android.view.View
import com.cineasteJE.android.R
import com.cineasteJE.android.entity.movie.Movie
import com.cineasteJE.android.listener.ItemClickListener

class MovieViewHolder(itemView: View, context: Context, listener: ItemClickListener?) :
    AbstractMovieViewHolder(itemView, context, listener) {

    override fun assignData(movie: Movie) {
        setBaseInformation(movie)

        movieRuntime.text = resources.getString(R.string.runtime, movie.runtime)
        listener?.let {
            view.setOnClickListener {
                listener.onItemClickListener(
                    movie.id,
                    arrayOf(view, poster, title, movieRuntime, movieVote)
                )
            }
        }
    }

    fun onItemSelected() {
        itemView.setBackgroundColor(Color.LTGRAY)
    }

    fun onItemClear() {
        itemView.setBackgroundColor(Color.WHITE)
    }
}
