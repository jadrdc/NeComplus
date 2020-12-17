package com.example.necomplus.repository.contract

import com.example.necomplus.models.ArtistResponse
import com.example.necomplus.models.TopTrackResponse
import io.reactivex.Observable

interface ArtistRepository {

    fun getTopArtist(country:String,limit:String): Observable<ArtistResponse>
    fun getTopTrackByArtist(artist:String,limit:String): Observable<TopTrackResponse>

}