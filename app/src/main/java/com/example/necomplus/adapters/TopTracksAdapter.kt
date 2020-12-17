package com.example.necomplus.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.necomplus.R
import com.example.necomplus.models.Artist
import com.example.necomplus.models.Track
import kotlinx.android.synthetic.main.top_track_item.view.*

class TopTracksAdapter(var trackList: MutableList<Track>, val context: Context) :
    RecyclerView.Adapter<TopTracksAdapter.TopTrackViewHolder>() {

    override fun getItemCount(): Int {
        return trackList.size
    }

    fun clear() {
        trackList.clear()
        notifyDataSetChanged()
    }

    fun addAll(listArtist: MutableList<Track>) {
        trackList = listArtist
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopTrackViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.top_track_item, parent, false)
        return TopTrackViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopTrackViewHolder, position: Int) {
        holder.drawUI(trackList[position])
    }

    class TopTrackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun drawUI(track: Track) {
            itemView.txtTrackName.text = track.name
            itemView.txtPlayCount.text = track.playcount

        }
    }
}