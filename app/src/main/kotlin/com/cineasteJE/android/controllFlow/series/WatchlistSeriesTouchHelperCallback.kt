package com.cineasteJE.android.controllFlow.series

import android.content.Context
import android.content.res.Resources
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.cineasteJE.android.R
import com.cineasteJE.android.adapter.series.SeriesListAdapter
import com.cineasteJE.android.controllFlow.BaseSnackBar

class WatchlistSeriesTouchHelperCallback(
    resources: Resources,
    linearLayoutManager: LinearLayoutManager,
    recyclerView: RecyclerView,
    seriesListAdapter: SeriesListAdapter,
    private val context: Context
) : BaseSeriesTouchHelperCallback(resources, linearLayoutManager, recyclerView, seriesListAdapter) {

    override val snackBar: BaseSnackBar
        get() = SeriesSnackBarWatchList(
            linearLayoutManager,
            recyclerView,
            seriesListAdapter,
            context
        )

    override val icon: Int
        get() = R.drawable.ic_add_to_history_white

    override val rightSwipeMessage: Int
        get() = R.string.series_seen
}
