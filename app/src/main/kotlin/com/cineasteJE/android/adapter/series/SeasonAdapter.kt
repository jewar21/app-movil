package com.cineasteJE.android.adapter.series

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.cineasteJE.android.R
import com.cineasteJE.android.entity.series.Season
import com.cineasteJE.android.entity.series.Series
import com.cineasteJE.android.listener.ItemClickListener
import com.cineasteJE.android.viewholder.series.SeasonViewHolder

internal class SeasonAdapter(
    private val context: Context,
    private val listener: ItemClickListener,
    val series: Series?
) : RecyclerView.Adapter<SeasonViewHolder>() {

    private val seasons: MutableList<Season> = mutableListOf()

    init {
        this.seasons.clear()
        series?.let {
            this.seasons.addAll(series.seasons)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.card_season, parent, false)

        return SeasonViewHolder(view, listener, context)
    }

    override fun onBindViewHolder(holder: SeasonViewHolder, position: Int) {
        holder.assignData(seasons[position])
    }

    override fun getItemCount(): Int {
        return seasons.size
    }
}
