package com.example.necomplus.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.necomplus.models.Artist
import com.example.necomplus.models.ArtistResponse
import com.example.necomplus.models.TopTrackResponse
import com.example.necomplus.models.Track
import com.example.necomplus.repository.contract.ArtistRepository
import com.example.necomplus.repository.remote.ArtistRemote
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

class TopTrackViewModel(application: Application) : AndroidViewModel(application) {
    private var topTrackArtist = MutableLiveData<MutableList<Track>>()
    private var repository: ArtistRepository = ArtistRemote()
    private var compositeDisposable = CompositeDisposable()


    fun getTopTrack(): MutableLiveData<MutableList<Track>> {
        return topTrackArtist
    }


    fun getTopArtistByCountry(artist: String, limit: String) {

        compositeDisposable.add(repository.getTopTrackByArtist(artist, limit)
            .subscribeWith(object : DisposableObserver<TopTrackResponse>() {
                override fun onComplete() {
                }

                override fun onNext(t: TopTrackResponse) {
                    topTrackArtist.postValue(t.toptracks.track as MutableList<Track>?)
                }

                override fun onError(e: Throwable) {
                    e.message?.let { Log.d("ERROR", it) }
                }
            })
        )

    }









}