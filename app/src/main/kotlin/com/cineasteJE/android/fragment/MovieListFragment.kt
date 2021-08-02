package com.cineasteJE.android.fragment

import android.app.Activity
import android.content.Intent
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.recyclerview.widget.ItemTouchHelper
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration

import com.cineasteJE.android.R
import com.cineasteJE.android.activity.MovieDetailActivity
import com.cineasteJE.android.activity.MovieSearchActivity
import com.cineasteJE.android.adapter.movie.MovieListAdapter
import com.cineasteJE.android.controllFlow.movie.HistoryListMovieTouchHelperCallback
import com.cineasteJE.android.controllFlow.movie.WatchlistMovieTouchHelperCallback
import com.cineasteJE.android.database.dao.BaseDao

class MovieListFragment : BaseListFragment() {

    private lateinit var movieListAdapter: MovieListAdapter

    override val subtitle: String
        get() = resources.getQuantityString(R.plurals.movieTitle, dataSetSize, dataSetSize)

    override val layout: Int
        get() = R.layout.fragment_movielist

    override val dataSetSize: Int
        get() = movieListAdapter.dataSetSize

    override val emptyListMessageByState: Int
        get() = if (watchState == WatchState.WATCH_STATE) {
            R.string.noMoviesOnWatchList
        } else {
            R.string.noMoviesOnWatchedList
        }

    override val correctCallBack: ItemTouchHelper.Callback
        get() = if (watchState == WatchState.WATCH_STATE) {
            WatchlistMovieTouchHelperCallback(
                layoutManager,
                movieListAdapter,
                customRecyclerView,
                resources
            )
        } else {
            HistoryListMovieTouchHelperCallback(
                layoutManager,
                movieListAdapter,
                customRecyclerView,
                resources
            )
        }

    override fun updateAdapter() {
        movieListAdapter.updateDataSet()
    }

    override fun initFab(activity: Activity, view: View) {
        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(getActivity(), MovieSearchActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun initRecyclerView() {
        customRecyclerView.layoutManager = layoutManager
        customRecyclerView.adapter = movieListAdapter

        val divider = ContextCompat.getDrawable(customRecyclerView.context, R.drawable.divider)
        val itemDecor = DividerItemDecoration(
            customRecyclerView.context,
            layoutManager.orientation
        )
        divider?.let {
            itemDecor.setDrawable(it)
        }
        customRecyclerView.addItemDecoration(itemDecor)
    }

    override fun initAdapter(activity: Activity) {
        movieListAdapter = MovieListAdapter(this, activity, this, watchState)
    }

    override fun filterOnQueryTextChange(newText: String) {
        (customRecyclerView.adapter as MovieListAdapter).filter.filter(newText)
    }

    override fun reorderEntries(filterType: FilterType) {
        when (filterType) {
            FilterType.ALPHABETICAL -> movieListAdapter.orderAlphabetical()
            FilterType.RELEASE_DATE -> movieListAdapter.orderByReleaseDate()
            FilterType.RUNTIME -> movieListAdapter.orderByRuntime()
        }

        movieListAdapter.notifyDataSetChanged()
    }

    override fun createIntent(itemId: Long, state: Int, activity: Activity): Intent {
        val intent = Intent(activity, MovieDetailActivity::class.java)
        intent.putExtra(BaseDao.MovieEntry.ID, itemId)
        intent.putExtra(getString(R.string.state), state)
        return intent
    }
}