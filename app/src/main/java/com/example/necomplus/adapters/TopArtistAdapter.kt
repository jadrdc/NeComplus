package com.example.necomplus.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.necomplus.R
import com.example.necomplus.models.Artist
import kotlinx.android.synthetic.main.top_artist_item.view.*

class TopArtistAdapter(var topArtisList: MutableList<Artist>, val context: Context,val listener:OnTopArtistInteraction) :
    RecyclerView.Adapter<TopArtistAdapter.TopArtistViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopArtistViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.top_artist_item, parent, false)
        return TopArtistViewHolder(view)
    }

    override fun getItemCount(): Int {
        return topArtisList.size
    }

    fun clear() {
        topArtisList.clear()
        notifyDataSetChanged()
    }

    fun addAll(listArtist: MutableList<Artist>) {
        topArtisList = listArtist
        notifyDataSetChanged()

    }

    override fun onBindViewHolder(holder: TopArtistViewHolder, position: Int) {

        holder.drawUI(topArtisList[position],position+1,listener)
    }


    class TopArtistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun drawUI(
            artist: Artist,
            rank: Int,
            listener: OnTopArtistInteraction
        ) {
        itemView.txtArtistName.text=artist.name
        itemView.txtListeners.text=artist.listeners
        itemView.artistRank.text= rank.toString()
         itemView.setOnClickListener {
             listener.onTouchArtist(artist)
         }
        }
    }

    interface  OnTopArtistInteraction
    {
        fun  onTouchArtist(artist: Artist)
    }

}