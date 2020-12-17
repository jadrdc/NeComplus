package com.example.necomplus.services.interfaces

import com.example.necomplus.models.ArtistResponse
import com.example.necomplus.models.TopTrackResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArtistService {

 @GET("?method=geo.gettopartists&format=json")
 fun getTopArtist(@Query("country") country:String,
                  @Query("limit") limit:String,
                  @Query("api_key") apikey:String):Observable<ArtistResponse>

    @GET("?method=artist.gettoptracks&format=json")
    fun getTopTrackByArtist(@Query("artist") artist:String,
                            @Query("limit") limit:String,
                            @Query("api_key") apikey:String):Observable<TopTrackResponse>
}

