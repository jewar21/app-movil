package com.cineasteJE.android.controllFlow.series

import android.content.res.Resources
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ItemTouchHelper

import com.cineasteJE.android.adapter.series.SeriesListAdapter
import com.cineasteJE.android.controllFlow.TouchHelperCallback
import com.cineasteJE.android.viewholder.series.SeriesViewHolder

abstract class BaseSeriesTouchHelperCallback(
    resources: Resources,
    linearLayoutManager: LinearLayoutManager,
    recyclerView: RecyclerView,
    val seriesListAdapter: SeriesListAdapter
) : TouchHelperCallback(resources, linearLayoutManager, recyclerView) {

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        seriesListAdapter.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
        return true
    }

    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            val seriesViewHolder = viewHolder as SeriesViewHolder
            seriesViewHolder.onItemSelected()
        }

        super.onSelectedChanged(viewHolder, actionState)
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        super.clearView(recyclerView, viewHolder)

        val seriesViewHolder = viewHolder as SeriesViewHolder
        seriesViewHolder.onItemClear()

        seriesListAdapter.updatePositionsInDb()
    }
}
