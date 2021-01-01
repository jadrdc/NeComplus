package com.example.necomplus.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.necomplus.R
import com.example.necomplus.adapters.TopArtistAdapter
import com.example.necomplus.models.Artist
import com.example.necomplus.utils.configs.ConfigObject
import com.example.necomplus.viewmodels.ArtistViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), TopArtistAdapter.OnTopArtistInteraction {

    lateinit var viewModel: ArtistViewModel
    lateinit var adapter: TopArtistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    viewModel = ViewModelProviders.of(this).get(
            ArtistViewModel::class.java
        )

        adapter = TopArtistAdapter(mutableListOf<Artist>(), this, this)
        topArtistList.adapter = adapter
        val linearLayoutManager: LinearLayoutManager? =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        topArtistList.layoutManager = linearLayoutManager

        viewModel.getTopArtistByCountry("Colombia", "10")
        viewModel.getTopListArtist().observe(this, Observer {
            indeterminateBar.visibility = View.GONE
            var sortedList =
                it.sortedWith(compareBy { it.listeners.toInt() }).reversed().toMutableList()
            adapter.clear()
            adapter.addAll(sortedList)
        })

    }

    override fun onTouchArtist(artist: Artist) {
        var intent = Intent(this, TopTracksActivity::class.java)
        intent.putExtra(ConfigObject.ARTIST, artist.name)
        this.startActivity(intent)
    }
}