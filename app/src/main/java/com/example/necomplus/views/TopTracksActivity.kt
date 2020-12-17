package com.example.necomplus.views

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.necomplus.R
import com.example.necomplus.adapters.TopTracksAdapter
import com.example.necomplus.models.Track
import com.example.necomplus.utils.configs.ConfigObject
import com.example.necomplus.viewmodels.TopTrackViewModel
import kotlinx.android.synthetic.main.activity_top_tracks.*


class TopTracksActivity : AppCompatActivity() {
    lateinit var viewModel: TopTrackViewModel
    var artist: String? = null
    lateinit var adapter: TopTracksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_tracks)
        viewModel = ViewModelProviders.of(this).get(
            TopTrackViewModel::class.java
        )
        intent.extras?.let {
            artist = it.getString(ConfigObject.ARTIST)
        }

        adapter = TopTracksAdapter(mutableListOf<Track>(), this)
        topTrack.adapter = adapter
        val linearLayoutManager: LinearLayoutManager? =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        topTrack.layoutManager = linearLayoutManager
        topTrack.addItemDecoration(
            DividerItemDecoration(
                topTrack.context,
                DividerItemDecoration.VERTICAL
            )
        )



        viewModel.getTopTrack().observe(this, Observer {
          indeterminateBar.visibility=View.GONE
            adapter.clear()
            adapter.addAll(it)
        })

        artist?.let { viewModel.getTopArtistByCountry(it, "5") }

    }
}