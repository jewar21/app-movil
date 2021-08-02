package com.cineasteJE.android.network

import com.cineasteJE.android.entity.series.Series

interface SeriesCallback {
    fun onFailure()
    fun onSuccess(series: Series)
}
