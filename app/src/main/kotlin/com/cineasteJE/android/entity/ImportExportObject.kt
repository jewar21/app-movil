package com.cineasteJE.android.entity

import com.cineasteJE.android.entity.movie.Movie
import com.cineasteJE.android.entity.series.Series

data class ImportExportObject(
    var movies: List<Movie> = emptyList(),
    var series: List<Series> = emptyList()
)
