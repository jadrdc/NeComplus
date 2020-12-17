package com.example.necomplus.repository.remote

import com.example.necomplus.models.ArtistResponse
import com.example.necomplus.models.TopTrackResponse
import com.example.necomplus.repository.contract.ArtistRepository
import com.example.necomplus.services.RetrofitInstance
import com.example.necomplus.services.interfaces.ArtistService
import com.example.necomplus.utils.configs.ConfigObject
import io.reactivex.Observable

class ArtistRemote : ArtistRepository {
    override fun getTopArtist(
        country: String,
        limit: String
    ): Observable<ArtistResponse> {
        val request = RetrofitInstance.buildService(ArtistService::class.java)
        return  request.getTopArtist(country,limit, ConfigObject.API_KEY)
    }

    override fun getTopTrackByArtist(artist: String, limit: String): Observable<TopTrackResponse> {
        val request = RetrofitInstance.buildService(ArtistService::class.java)
        return  request.getTopTrackByArtist(artist,limit, ConfigObject.API_KEY)    }
}