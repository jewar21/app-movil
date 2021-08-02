package com.cineasteJE.android.viewholder.series

import android.content.Context
import android.text.TextUtils
import android.view.View
import android.widget.TextView

import com.cineasteJE.android.R
import com.cineasteJE.android.entity.series.Series
import com.cineasteJE.android.listener.ItemClickListener
import com.cineasteJE.android.viewholder.BaseViewHolder

abstract class AbstractSeriesViewHolder(
    itemView: View,
    listener: ItemClickListener,
    context: Context
) :
    BaseViewHolder(itemView, listener, context) {

    private val vote: TextView = itemView.findViewById(R.id.vote)

    abstract fun assignData(series: Series, position: Int)

    fun setBaseInformation(series: Series) {
        title.text = series.name
        vote.text = resources.getString(R.string.vote, series.voteAverage.toString())

        var posterName = series.posterPath
        if (TextUtils.isEmpty(posterName)) {
            posterName = series.posterPath
        }
        setPoster(posterName)
    }
}
