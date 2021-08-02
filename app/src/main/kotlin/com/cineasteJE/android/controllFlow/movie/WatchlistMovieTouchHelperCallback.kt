package com.cineasteJE.android.controllFlow.movie

import android.content.res.Resources
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.cineasteJE.android.R
import com.cineasteJE.android.adapter.movie.MovieListAdapter
import com.cineasteJE.android.controllFlow.BaseSnackBar

class WatchlistMovieTouchHelperCallback(
    linearLayoutManager: LinearLayoutManager,
    movieListAdapter: MovieListAdapter,
    recyclerView: RecyclerView,
    resources: Resources
) : BaseMovieTouchHelperCallback(linearLayoutManager, movieListAdapter, recyclerView, resources) {

    override val snackBar: BaseSnackBar
        get() = MovieSnackBarWatchList(linearLayoutManager, movieListAdapter, recyclerView)

    override val icon: Int
        get() = R.drawable.ic_add_to_history_white

    override val rightSwipeMessage: Int
        get() = R.string.movie_seen
}
