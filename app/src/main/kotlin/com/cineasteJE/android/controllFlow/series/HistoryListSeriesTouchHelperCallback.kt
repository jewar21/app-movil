package com.cineasteJE.android.controllFlow.series

import android.content.res.Resources
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.cineasteJE.android.R
import com.cineasteJE.android.adapter.series.SeriesListAdapter
import com.cineasteJE.android.controllFlow.BaseSnackBar

class HistoryListSeriesTouchHelperCallback(
    resources: Resources,
    linearLayoutManager: LinearLayoutManager,
    recyclerView: RecyclerView,
    seriesListAdapter: SeriesListAdapter
) : BaseSeriesTouchHelperCallback(resources, linearLayoutManager, recyclerView, seriesListAdapter) {

    override val icon: Int
        get() = R.drawable.ic_add_to_watchlist_white

    override val snackBar: BaseSnackBar
        get() = SeriesSnackBarHistory(linearLayoutManager, recyclerView, seriesListAdapter)

    override val rightSwipeMessage: Int
        get() = R.string.not_seen
}
