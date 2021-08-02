package com.cineasteJE.android.activity

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.reflect.TypeToken
import com.cineasteJE.android.R
import com.cineasteJE.android.adapter.series.SeriesSearchQueryAdapter
import com.cineasteJE.android.database.dao.BaseDao
import com.cineasteJE.android.entity.series.Series
import com.cineasteJE.android.network.NetworkClient
import com.cineasteJE.android.network.NetworkRequest
import java.lang.reflect.Type

class SeriesSearchActivity : AbstractSearchActivity() {

    private lateinit var seriesQueryAdapter: SeriesSearchQueryAdapter

    override val layout: Int
        get() = R.layout.activity_series_search

    override val listAdapter: RecyclerView.Adapter<*>
        get() = seriesQueryAdapter

    override val listType: Type
        get() = object : TypeToken<List<Series>>() {
        }.type

    override fun getIntentForDetailActivity(itemId: Long): Intent {
        val intent = Intent(this, SeriesDetailActivity::class.java)
        intent.putExtra(BaseDao.SeriesEntry.ID, itemId)
        intent.putExtra(this.getString(R.string.state), R.string.searchState)
        return intent
    }

    override fun initAdapter() {
        seriesQueryAdapter = SeriesSearchQueryAdapter(this)
    }

    override fun getSuggestions() {
        val client = NetworkClient(NetworkRequest(resources).popularSeries)
        client.sendRequest(networkCallback)
    }

    override fun searchRequest(searchQuery: String) {
        val client = NetworkClient(NetworkRequest(resources).searchSeries(searchQuery))
        client.sendRequest(networkCallback)
    }

    override fun getRunnable(json: String, listType: Type): Runnable {
        return Runnable {
            val series: List<Series> = gson.fromJson(json, listType)
            seriesQueryAdapter.addSeries(series)
            progressBar.visibility = View.GONE
        }
    }
}